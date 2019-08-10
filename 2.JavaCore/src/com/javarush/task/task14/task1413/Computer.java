package com.javarush.task.task14.task1413;

public class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer(Keyboard kb, Mouse ms, Monitor mn) {
        keyboard = kb;
        mouse = ms;
        monitor = mn;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}