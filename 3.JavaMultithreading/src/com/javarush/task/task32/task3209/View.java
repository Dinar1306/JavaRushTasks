package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.TextEditMenuListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.font.TextAttribute.FONT;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager  = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
    }

    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){
        //Создавать новый объект типа JMenuBar. Это и будет наша панель меню
        JMenuBar menuBar = new JMenuBar();
        //С помощью MenuHelper инициализировать меню
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        //Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому, как это мы делали с панелью вкладок
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane1);
        tabbedPane.setPreferredSize(new Dimension(800, 450));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public boolean canUndo(){ return undoManager.canUndo();}
    public boolean canRedo() { return undoManager.canRedo();}

    public void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    //Пункты меню, отвечающие за стиль, шрифт, цвет и т.д. должны быть доступны только тогда, когда в нашем редакторе
    // выбрана первая вкладка.
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex()==0?true:false;
        //true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
    }

    // геттер для слушателя изменений
    public UndoListener getUndoListener() {
        return undoListener;
    }

    //должен сбрасывать все правки в менеджере
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
        //
    }

    // Выбирать html вкладку
    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    //должен получать документ у контроллера и устанавливать его в панель редактирования htmlTextPane
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    //должен показывать диалоговое окно с информацией о программе.
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "It hard to be God", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    //вызывается, когда произошла смена выбранной вкладки
    public void selectedTabChanged(){
        switch (tabbedPane.getSelectedIndex()){
            case 0 : { //Если выбрана вкладка с индексом 0 (html вкладка)
                controller.setPlainText(plainTextPane.getText());
                //получить текст из plainTextPane и установить его в контроллер
                break;
            }
            case 1 : { //Если выбрана вкладка с индексом 1 (вкладка с html текстом)
                plainTextPane.setText(controller.getPlainText());
                //получить текст у контроллера и установить его в панель plainTextPane
                break;
            }
        }
        resetUndo(); //Сбросить правки
    }

    @Override
    //будет вызваться при выборе пунктов меню, у которых наше представление указано в виде слушателя событий
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
        }

    }
}
