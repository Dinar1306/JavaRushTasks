package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    //будет сбрасывать текущий документ
    public void resetDocument(){
        if (!(document==null)){
            // удаляет существующий документ
            document.removeUndoableEditListener(view.getUndoListener());
        }

        // создает документ по умолчанию
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    //будет записывать переданный текст с html тегами в документ document
    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader, document, 0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    //Он должен получать текст из документа со всеми html тегами.
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    //метод создания нового документа
    public void createNewDocument() {
        view.selectHtmlTab();            //Выбирать html вкладку у представления
        resetDocument();                   //Сбрасывать текущий документ.
        view.setTitle("HTML редактор");  //Устанавливать новый заголовок окна
        view.resetUndo();                //Сбрасывать правки в Undo менеджере
        currentFile = null;              //Обнулить переменную currentFile
    }

    public void openDocument() {
        view.selectHtmlTab();            //Выбирать html вкладку у представления
        JFileChooser jFileChooser = new JFileChooser(); //Создавать новый объект для выбора файла
        jFileChooser.setFileFilter(new HTMLFileFilter()); //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int choose = jFileChooser.showOpenDialog(view);  //Показывать диалоговое окно "Save File" для выбора файла.
        if (choose == JFileChooser.APPROVE_OPTION){      //Если пользователь подтвердит выбор файла:
            currentFile = jFileChooser.getSelectedFile(); //Установить новое значение currentFile.
            resetDocument();                             //Сбросить документ.
            view.setTitle(currentFile.getName());       //Установить имя файла в заголовок у представления.
            try {
                FileReader fileReader = new FileReader(currentFile);  //Создать FileReader, используя currentFile.
                new HTMLEditorKit().read(fileReader, document, 0); //Вычитать данные из FileReader-а в документ document
                view.resetUndo();                                    //Сбросить правки (вызвать метод resetUndo представления)
            } catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
        }

    public void saveDocument() {
        if (currentFile == null) saveDocumentAs();
        else {
            view.selectHtmlTab();            //Выбирать html вкладку у представления
            view.setTitle(currentFile.getName());         //Устанавливать имя файла в качестве заголовка окна представления.
            try {
                FileWriter fileWriter = new FileWriter(currentFile);  //Создавать FileWriter на базе currentFile.
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength()); //Переписывать данные из документа document в объекта FileWriter
                // Метод не должен кидать исключения
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();            //Выбирать html вкладку у представления
        JFileChooser jFileChooser = new JFileChooser(); //Создавать новый объект для выбора файла
        jFileChooser.setFileFilter(new HTMLFileFilter()); //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int choose = jFileChooser.showSaveDialog(view);  //Показывать диалоговое окно "Save File" для выбора файла.
        if (choose == JFileChooser.APPROVE_OPTION){      //Если пользователь подтвердит выбор файла:
            currentFile = jFileChooser.getSelectedFile(); //Сохранять выбранный файл в поле currentFile.
            view.setTitle(currentFile.getName());         //Устанавливать имя файла в качестве заголовка окна представления.
            try {
                FileWriter fileWriter = new FileWriter(currentFile);  //Создавать FileWriter на базе currentFile.
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength()); //Переписывать данные из документа document в объекта FileWriter
                // Метод не должен кидать исключения
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }
}

//    Твой html редактор готов!
//        Ты научился:
//        - Создавать приложения с графическим интерфейсом.
//        - Работать с диалоговыми окнами.
//        - Пользоваться классами из библиотеки Swing.
//        - Реализовывать взаимодействие компонентов программы с помощью событий, слушателей, действий.
//        - Усилил свои знания в области MVC.
//
//        Что можно улучшить в разработанном редакторе:
//        - Добавить панель инструментов, повторяющую функционал меню.
//        - Добавить подсветку html тегов на второй вкладке.
//        - Добавить возможность загрузки документа из Интернет.
//        - Расширить возможности редактора (вставка картинки, ссылки и т.д.)