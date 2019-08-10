package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
Написать Фабрику(Factory) по производству кур(Hen):

1. Создать класс Hen.
1.1. Сделать его абстрактным.
1.2. Добавить в класс абстрактный метод int getCountOfEggsPerMonth().
1.3. Добавить в класс метод String getDescription(), который возвращает строку "Я - курица.".
2. Создать класс RussianHen, который наследуется от Hen.
3. Создать класс UkrainianHen, который наследуется от Hen.
4. Создать класс MoldovanHen, который наследуется от Hen.
5. Создать класс BelarusianHen, который наследуется от Hen.
6. В каждом из четырех последних классов написать свою реализацию метода getCountOfEggsPerMonth.
Методы должны возвращать количество яиц в месяц от данного типа куриц.
7. В каждом из четырех последних классов написать свою реализацию метода getDescription.

Методы должны возвращать строку вида:
<getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">
где Sssss - название страны
где N - количество яиц в месяц

8. В классе HenFactory реализовать метод getHen, который возвращает соответствующую стране породу кур.
9. Все созданные вами классы должны быть в отдельных файлах.


Требования:
1. Класс Hen должен быть абстрактным.
2. Класс Hen должен содержать абстрактный метод int getCountOfEggsPerMonth().
3. В классе Hen должен быть реализован метод String getDescription(), который возвращает строку "Я - курица.".
4. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны наследоваться от класса Hen и быть созданы в отдельных файлах.
5. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны реализовывать метод getCountOfEggsPerMonth, который должен возвращать количество яиц в месяц от данного типа куриц.
6. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны переопределять метод getDescription родительского класса, таким образом, чтобы возвращаемая ими строка имела вид: + < Моя страна - Sssss. Я несу N яиц в месяц.> где Sssss - название страны, а N - количество яиц в месяц.
7. Метод getHen должен быть реализован в классе HenFactory и должен возвращать тип кур для переданной в него страны.
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen_1 = HenFactory.getHen(Country.BELARUS);
        hen_1.getCountOfEggsPerMonth();
        System.out.println(hen_1.getDescription());

        Hen hen_2 = HenFactory.getHen(Country.UKRAINE);
        hen_2.getCountOfEggsPerMonth();
        System.out.println(hen_2.getDescription());

        Hen hen_3 = HenFactory.getHen(Country.MOLDOVA);
        hen_3.getCountOfEggsPerMonth();
        System.out.println(hen_3.getDescription());

        Hen hen_4 = HenFactory.getHen(Country.RUSSIA);
        hen_4.getCountOfEggsPerMonth();
        System.out.println(hen_4.getDescription());
    }

    static class HenFactory implements Country{

        static Hen getHen(String country) {
            //напишите тут ваш код
            if (country.equals("Belarus")){
                Hen hen_1 = new BelarusianHen();
                return hen_1;
            }
            if (country.equals("Moldova")){
                Hen hen_2 = new MoldovanHen();
                return hen_2;
            }
            if (country.equals("Ukraine")){
                Hen hen_3 = new UkrainianHen();
                return hen_3;
            }
            if (country.equals("Russia")){
                Hen hen_3 = new RussianHen();
                return hen_3;
            }
            else return null;
            /*
            if (country.equals("Belarus")){
                return hen_1.getDescription(country);
            }
            Hen.getDescription(country)*/
            //return hen_1;
        }
    }


}
