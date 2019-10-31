package com.javarush.task.task37.task3711;

public class Computer {
    public CPU cpu = new CPU();
    public Memory memory = new Memory();
    public HardDrive hardDrive = new HardDrive();

    public void run(){
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
