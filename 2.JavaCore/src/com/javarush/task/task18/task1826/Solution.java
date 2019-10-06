package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.

Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        switch (args[0]){
            case "-e":
                // Создаем поток-чтения
                FileInputStream inputStream = new FileInputStream(args[1]);
                // Создаем поток-записи-байт-в-файл
                FileOutputStream outputStream = new FileOutputStream(args[2]);
                //byte[] buffer = new byte[inputStream.available()]; //читаем файл
                while (inputStream.available() > 0) {  //читаем весь файл одним куском
                    outputStream.write(~inputStream.read()); // шифруем (побитовую инверсия)
                }
                outputStream.close();
                inputStream.close();
                break;
            case "-d":
                // Создаем поток-чтения
                FileInputStream inputStream2 = new FileInputStream(args[1]);
                // Создаем поток-записи-байт-в-файл
                FileOutputStream outputStream2 = new FileOutputStream(args[2]);
                //byte[] buffer2 = new byte[inputStream2.available()]; //читаем файл
                while (inputStream2.available() > 0) {  //читаем весь файл одним куском
                    outputStream2.write(~inputStream2.read()); // расшифруем (побитовую инверсия)
                }
                outputStream2.close();
                inputStream2.close();
                break;
        }

    }

}
