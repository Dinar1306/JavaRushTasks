package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {
    //Создай и инициализируй поле, отвечающее за модель ClientGuiModel model.
    private ClientGuiModel model = new ClientGuiModel();

    //Создай и инициализируй поле, отвечающее за представление ClientGuiView view
    private ClientGuiView view = new ClientGuiView(this);

    //6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
    public ClientGuiModel getModel(){
        return this.model;
    }

    //Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

    @Override //должен создавать и возвращать объект типа GuiSocketThread
    protected SocketThread getSocketThread() {
        //return super.getSocketThread();
        return new GuiSocketThread();
    }

    @Override //должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
    public void run() {
        //super.run();
        getSocketThread().run();
    }

    //в) getServerAddress(), getServerPort(), getUserName().
    //Они должны вызывать одноименные методы из представления (view).
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    //Добавь внутренний класс GuiSocketThread унаследованный от SocketThread.
    public class GuiSocketThread extends SocketThread{
        //В нем переопредели следующие методы:
        //а) - должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
        @Override
        protected void processIncomingMessage(String message){
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            //super.informAboutAddingNewUser(userName);
            //должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override //должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
        protected void informAboutDeletingNewUser(String userName) {
            //super.informAboutDeletingNewUser(userName);
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override //должен вызывать аналогичный метод у представления.
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            //super.notifyConnectionStatusChanged(clientConnected);
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
