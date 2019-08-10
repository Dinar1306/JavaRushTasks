package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        //String file1 = new BufferedReader(new InputStreamReader(System.in)).readLine(); тоже работает, но BufferedReader не закрыть
        //String file2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // объект потока ввода
        String file1 = br.readLine();   //имя первого файла
        String file2 = br.readLine();   //имя второго файла
        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);
        boolean isOdd = false;
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
         if (isOdd == true) {       //если нечетный порядковый номер
             writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
             isOdd = false;
         } else isOdd = true;

        }//while

        //закрываем потоки после использования
        reader.close();
        writer.close();
        br.close();
    }
}
