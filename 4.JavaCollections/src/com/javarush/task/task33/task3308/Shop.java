package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {
//            2. В классе Shop должно быть создано поле goods типа Goods.
//            3. В классе Shop должно быть создано поле count типа int.
//            4. В классе Shop должно быть создано поле profit типа double.
//            5. В классе Shop должен быть создан массив строк secretData.

    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    private static class Goods {
        @XmlElement
        public List<String> names = new ArrayList<>();
    }
}
