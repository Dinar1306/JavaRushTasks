package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }


    // Получает изменение и передает в менеджер
    @Override
    public void undoableEditHappened(UndoableEditEvent e){
        undoManager.addEdit(e.getEdit());
    }
}
