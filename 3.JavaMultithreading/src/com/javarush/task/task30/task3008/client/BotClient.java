package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    //Добавь метод main(). Он должен создавать новый объект BotClient и вызывать у него метод run().
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends Client.SocketThread{
        //Переопредели метод clientMainLoop()
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            //С помощью метода sendTextMessage() отправь сообщение с текстом "Привет чатику. Я бот. Понимаю команды:
            // дата, день, месяц, год, время, час, минуты, секунды."
            String text = "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.";
            sendTextMessage(text);

            //Вызови реализацию clientMainLoop() родительского класса
            super.clientMainLoop();
        }

        //Переопредели метод processIncomingMessage(String message)
        @Override
        protected void processIncomingMessage(String message) {
            //Вывести в консоль текст полученного сообщения message.
            super.processIncomingMessage(message);

            //Получить из message имя отправителя и текст сообщения. Они разделены ": "
            String name = message.split(": ")[0];
            String mess = message.replaceFirst(name + ": ", "");

            Calendar calendar = new GregorianCalendar();

            //Отправить ответ в зависимости от текста принятого сообщения.
            switch (mess){
                case "дата" : { //текущую дату в формате "d.MM.YYYY";
//                    DateFormat df = new SimpleDateFormat("d.MM.YYYY");
//                    sendTextMessage("Информация для "+name+": "+ df.format(calendar.getTime()));
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime())));
                    break;
                }
                case "день" : { //"день" - в формате "d";
//                    DateFormat df = new SimpleDateFormat("d");
//                    sendTextMessage("Информация для "+name+": "+df.format(calendar.getTime()));
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("d").format(Calendar.getInstance().getTime())));
                    break;
                }
                case "месяц" : { //"день" - в формате "d";
//                    DateFormat df = new SimpleDateFormat("MMMM");
//                    sendTextMessage("Информация для "+name+": "+ df.format(calendar.getTime()));
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime())));
                    break;
                }
                case "год":
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime())));
                    break;
                case "время":
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime())));
                    break;
                case "час":
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("H").format(Calendar.getInstance().getTime())));
                    break;
                case "минуты":
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("m").format(Calendar.getInstance().getTime())));
                    break;
                case "секунды":
                    sendTextMessage(String.format("Информация для %s: %s", name,
                            new SimpleDateFormat("s").format(Calendar.getInstance().getTime())));
                    break;
            }


        }
    }
    //Переопредели методы:
    //а) getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
    //б) shouldSendTextFromConsole(). Он должен всегда возвращать false.
    //Мы не хотим, чтобы бот отправлял текст введенный в консоль.
    //в) getUserName(), метод должен генерировать новое имя бота, например: date_bot_X, где X - любое число от 0 до 99.
    //Для генерации X используй метод Math.random().
    @Override
    protected String getUserName() {
//        int x = (int)Math.random()*100;
//        return "date_bot_"+x;
        return "date_bot_" + (int)(Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }


}
