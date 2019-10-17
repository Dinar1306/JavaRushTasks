package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;

//import static org.slf4j.event.Level.DEBUG;

/*
В Intellij IDEA Alt+Ctrl+Shift+S -> Global Libraries -> New Global Library -> From Maven...

В строке поиска в открывшемся окне укажи: org.slf4j:slf4j-api:1.7.23 -> Поиск (Shift+Enter)
Укажи куда скачать библиотеку логирования.
Выбрери к какому модулю проекта подключить библиотеку slf4j-api: нужно выбрать
4.JavaCollections -> OK
Apply -> OK.

Добавление логирования в класс
Посмотри где бы ты в классе Solution применил какой уровень логирования?

В класс Solution нужно добавить вызовы методов уровня:
error - 1 раз;
debug - 6 раз - используй при изменениях значений полей класса;
trace - 4 раза - используй для отслеживания пути выполнения програмы;
Сообщения в логах старайся писать информативные.
Остальной код не изменяй.


Требования:
1. В классе Solution должно существовать приватное статическое финальное поле logger.
2. Добавь логирование уровня error один раз.
3. Добавь логирование уровня debug шесть раз.
4. Добавь логирование уровня trace четыре раза. //Мелкое сообщение при отладке
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {

        logger.debug("Присвоение значения в конструкторе", value1, value2, value3);

        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {
        Solution s = new Solution(2,"hello",new Date());
        s.setValue1(1);
        s.setValue2("Hello, java");
        s.setValue3(new Date());
        s.calculateAndSetValue3(5);
        s.printDateAsLong();
        s.printString();
        s.divide(1,0);

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("вход в метод");
        value -= 133;
        //logger.debug("Присвоение значения value в методе calculateAndSetValue3()",value);
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("Присвоение значения value1 в методе calculateAndSetValue3() в секции if",value1);
        } else {
            value1 = (int) value;
            logger.debug("Присвоение значения value1 в методе calculateAndSetValue3() после else",value1);
        }
    }

    public void printString() {
        logger.trace("вход в метод");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("вход в метод");
        if (value3 != null) {
            System.out.println(value3.getTime());

        }
    }

    public void divide(int number1, int number2) {
        logger.trace("вход в метод");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException в методе divide: знаменатель = ", number2);
        }
    }

    public void setValue1(int value1) {
        logger.debug("Присвоение значения value1 в методе setValue1",value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("Присвоение значения value2 в методе setValue1",value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        //logger.debug("Присвоение значения в методе setValue3()",value3);
        this.value3 = value3;
        logger.debug("Присвоение значения value3 в методе setValue1",value3);
    }
}
