package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
Сервер должен поддерживать множество соединений с разными клиентами одновременно.
Это можно реализовать с помощью следующего алгоритма:

- Сервер создает серверное сокетное соединение.
- В цикле ожидает, когда какой-то клиент подключится к сокету.
- Создает новый поток обработчик Handler, в котором будет происходить обмен сообщениями с клиентом.
- Ожидает следующее соединение.

Класс Handler должен реализовывать протокол общения с клиентом.
Выделим из протокола отдельные этапы и реализуем их с помощью отдельных методов:

Этап первый - это этап рукопожатия (знакомства сервера с клиентом).
Реализуем его с помощью приватного метода String serverHandshake(Connection connection) throws IOException, ClassNotFoundException.
Метод в качестве параметра принимает соединение connection, а возвращает имя нового клиента.

Реализация метода должна:
1) Сформировать и отправить команду запроса имени пользователя
2) Получить ответ клиента
3) Проверить, что получена команда с именем пользователя
4) Достать из ответа имя, проверить, что оно не пустое и пользователь с таким именем еще не подключен (используй connectionMap)
5) Добавить нового пользователя и соединение с ним в connectionMap
6) Отправить клиенту команду информирующую, что его имя принято
7) Если какая-то проверка не прошла, заново запросить имя клиента
8) Вернуть принятое имя в качестве возвращаемого значения
 */

public class Server {
    private static class Handler extends Thread{
        private Socket socket;

        private String serverHandshake(Connection connection)throws IOException, ClassNotFoundException{
            String newClientName;

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));        // Сформировать и отправить команду запроса имени пользователя
                Message answer = connection.receive();                         // Получить ответ клиента
                if (answer.getType() == MessageType.USER_NAME) {               // Проверить, что получена команда с именем пользователя
                    newClientName = answer.getData();                          // Достать из ответа имя, проверить,
                    if (!newClientName.isEmpty()) {                            // что оно не пустое и пользователь
                        if (!connectionMap.containsKey(newClientName)) {       // с таким именем еще не подключен (используй connectionMap)
                            connectionMap.put(newClientName, connection);      // Добавить нового пользователя и соединение с ним в connectionMap
                            connection.send(new Message(MessageType.NAME_ACCEPTED)); //Отправить клиенту команду информирующую, что его имя принято
                            return newClientName;                              //Вернуть принятое имя в качестве возвращаемого значения
                        }
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> entry: connectionMap.entrySet()) {
                try {
                    if (!entry.getKey().equals(userName)){ //отправить сообщение всем кроме этого пользователя
                        connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                    }

                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Не удалось отправить сообщение");
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive(); //Принимать сообщение клиента
                if (message != null && message.getType() == MessageType.TEXT) { //Если принятое сообщение - это текст (тип TEXT)
                    //формировать новое текстовое сообщение путем конкатенации: имени клиента, двоеточия, пробела и текста сообщения.
                    //Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage().
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    //Если принятое сообщение не является текстом, вывести сообщение об ошибке
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }

        //главный метод класса Handler, который будет вызывать все вспомогательные методы, написанные ранее.
        //Реализуем метод void run()
        @Override
        public void run(){
            //Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить
            // с помощью метода getRemoteSocketAddress()
            ConsoleHelper.writeMessage("Установлено новое соединение с: " + socket.getRemoteSocketAddress());
            String clientName = null;

            try (Connection connection = new Connection(socket);){ ////Создавать Connection, используя поле socket.
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
                clientName = serverHandshake(connection);

                //Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED).
                //notifyUsers(connection, clientName);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));

                //Сообщать новому участнику о существующих участниках.
                notifyUsers(connection, clientName);

                //Запускать главный цикл обработки сообщений сервером.
                serverMainLoop(connection, clientName);
//Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию, что произошла
// ошибка при обмене данными с удаленным адресом.
            } catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("An error occurred while communicating with the remote address");
            } finally{ //Обеспечить закрытие соединения при возникновении исключения.
                if (clientName != null){
                    //После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя, мы должны
                    // удалить запись для этого имени из connectionMap и разослать всем остальным участникам сообщение
                    // с типом USER_REMOVED и сохраненным именем.
                    connectionMap.remove(clientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
                    ConsoleHelper.writeMessage(String.format("Connection with remote address (%s) is closed.", socket.getRemoteSocketAddress()));
                }
            }
        }

        public Handler(Socket socket) {
            this.socket = socket;
        }
    } //class Handler

    //ключом будет имя клиента, а значением - соединение с ним.
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();
    //библиотека java.util.concurrent, т.к. работа с этим полем будет происходить из разных потоков и нужно обеспечить потокобезопасность.

    //должен отправлять сообщение message всем соединениям из connectionMap.
    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> entry: connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            }
        }
    }


    public static void main(String[] args) {
        //Запрашивать порт сервера, используя ConsoleHelper.
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server started...");
            //В бесконечном цикле слушать и принимать входящие сокетные соединения только что созданного серверного сокета
            while (true) {
                //Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта.
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Something wrong, Server socket closed.");
        }
        //Предусмотреть закрытие серверного сокета в случае возникновения исключения.
        //Если исключение Exception все же произошло, поймать его и вывести сообщение об ошибке.
        // ( try with resourses )
    }
}
