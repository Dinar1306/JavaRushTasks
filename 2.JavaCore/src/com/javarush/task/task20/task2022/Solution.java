package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5


Требования:
1. Поле stream должно быть объявлено с модификатором transient.
2. В методе writeObject(ObjectOutputStream out) не должен быть вызван метод close у потока полученного в качестве параметра.
3. В методе readObject(ObjectInputStream in) не должен быть вызван метод close у потока полученного в качестве параметра.
4. В методе readObject(ObjectInputStream in) поле stream должно быть инициализировано новым объектом типа FileOutputStream с параметрами(fileName, true).
5. В конструкторе класса Solution поле stream должно быть инициализировано новым объектом типа FileOutputStream с параметром(fileName).
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fn;


    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
         fn = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }


    /*В методе readObject(ObjectInputStream in) поле stream должно быть инициализировано новым объектом 
    типа FileOutputStream с параметрами(fileName, true).*/
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        
        stream = new FileOutputStream(fn, true);

        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution(fileOutput.toString());
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        loadedObject.close();

    }
}
