package com.javarush.task.task30.task3008.client;
//Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера, подсоединиться к указанному адресу,
// получить запрос имени от сервера, спросить имя у пользователя, отправить имя пользователя серверу, дождаться принятия имени сервером.
//После этого клиент может обмениваться текстовыми сообщениями с сервером.
//Обмен сообщениями будет происходить в двух параллельно работающих потоках.
//Один будет заниматься чтением из консоли и отправкой прочитанного серверу, а второй поток будет получать данные от сервера
// и выводить их в консоль.

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    //должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }

    //должен запрашивать ввод порта сервера и возвращать его.
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }

    //должен запрашивать и возвращать имя пользователя.
    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }

    //данной реализации клиента всегда должен возвращать true (мы всегда отправляем текст введенный в консоль).
    //Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент, унаследованный от нашего,
    // который не должен отправлять введенный в консоль текст.
    protected boolean shouldSendTextFromConsole() {return true;}

    //должен создавать и возвращать новый объект класса SocketThread
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    //создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            System.out.println("Клиенту не удалось отправить сообщение");
            clientConnected = false;
        }
    }

    //Реализация метода run должна:
    //а) Создавать новый сокетный поток с помощью метода getSocketThread().
    //б) Помечать созданный поток как daemon, это нужно для того, чтобы при выходе из программы вспомогательный поток
    // прервался автоматически.
    //в) Запустить вспомогательный поток.
    //г) Заставить текущий поток ожидать, пока он не получит нотификацию из другого потока.
    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Connection was interrupted. " + e.getMessage());
                System.exit(1);
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        String text = "";
        while (clientConnected) {
            text = ConsoleHelper.readString();
            if (text.equalsIgnoreCase("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(text);
            }
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }

    //будет отвечать за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
    public class SocketThread extends Thread{
        //- должен выводить текст message в консоль.
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        //- должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату.
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        //- должен выводить в консоль, что участник с именем userName покинул чат.
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        //- этот метод должен:
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            //Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром
            Client.this.clientConnected = clientConnected;

            //Оповещать (пробуждать ожидающий) основной поток класса Client.
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        //Этот метод будет представлять клиента серверу.
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if (message.getType()==MessageType.NAME_REQUEST){ //если сервер запросил имя
                    //запросить ввод имени пользователя с помощью метода getUserName()
                    String userName = getUserName();

                    //создать новое сообщение с типом MessageType.USER_NAME и введенным именем, отправить сообщение серверу
                    Message messageOut = new Message(MessageType.USER_NAME, userName);
                    connection.send(messageOut);
                }//MessageType.NAME_REQUEST
                else if (message.getType()==MessageType.NAME_ACCEPTED) { //если сервер принял имя
                    //нужно об этом сообщить главному потоку, он этого очень ждет.
                    notifyConnectionStatusChanged(true);
                    break;
                }
                //Если пришло сообщение с каким-либо другим типом, кинь исключение
                else throw new IOException("Unexpected MessageType");
            } // while true
        }

        //метод будет реализовывать главный цикл обработки сообщений сервера.
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true){
                //Получи сообщение от сервера, используя соединение connection
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT){ //Если это текстовое сообщение (тип MessageType.TEXT)
                    //обработай его с помощью метода processIncomingMessage().
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED){ //Если это сообщение с типом MessageType.USER_ADDED
                    // обработай его с помощью метода informAboutAddingNewUser().
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED){ //Если это сообщение с типом MessageType.USER_REMOVED
                    // обработай его с помощью метода informAboutDeletingNewUser().
                    informAboutDeletingNewUser(message.getData());
                }
                //Если клиент получил сообщение какого-либо другого типа, брось исключение IOException("Unexpected MessageType").
                else throw new IOException("Unexpected MessageType");
            }
        }

        public void run(){
            try {
                //Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
                String serverAdress = Client.this.getServerAddress();
                int serverPort = Client.this.getServerPort();

                //Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
                Socket socket = new Socket(serverAdress, serverPort);

                //Создай объект класса Connection, используя сокет
                Client.this.connection = new Connection(socket);

                //Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
                clientHandshake();

                //Вызови метод, реализующий основной цикл обработки сообщений сервера.
                clientMainLoop();
            }

            //При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме,
            catch (IOException | ClassNotFoundException e) {
               // используя notifyConnectionStatusChanged() и false в качестве параметра.
                ConsoleHelper.writeMessage("Connection was interrupted. " + e.getMessage());
                notifyConnectionStatusChanged(false);
            }

        }

    } //SocketThread
}
