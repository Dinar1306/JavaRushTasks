package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность

Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List.
2. Класс Solution должен содержать public static поле forRemoveLines типа List.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static { //стат.блок для выполнения при инициализации объекта Solution
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String firstFileName = br.readLine();   //имя первого файла
            String secondFileName = br.readLine();  //имя второго файла
            try (BufferedReader reader = new BufferedReader(new FileReader(firstFileName))) { //первый файл в конструктор
                String s;
                while ((s = reader.readLine())!= null) {
                    allLines.add(s);
                }
            }
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(secondFileName))) { //второй файл в конструктор
                String sx;
                while ((sx = bufferedReader.readLine())!= null) {
                    forRemoveLines.add(sx);
                }
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(); //создаем объект Solution, при этом выполняется стат.блок с чтением файлов и заполнением списков
        try {
            solution.joinData(); // запускаем метод joinData() и отлавливаем наше исключение
        } catch (CorruptedDataException e) {
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) { // если forRemoveLines содержится в allLines
            allLines.removeAll(forRemoveLines);     // то удаляем
        } else {
            allLines.clear();                       //иначе очищаем
            throw new CorruptedDataException();     //и кидаем исключение
        }
    }

}
