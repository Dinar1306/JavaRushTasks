package com.javarush.task.task33.task3309;

/* 
Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку — xml представление объекта obj.
В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.
Пример вызова:
toXmlWithComment(firstSecondObject, «second», «it’s a comment»)
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second><![CDATA[need CDATA because of < and >]]></second>
<!--it's a comment-->
<second/>
</first>
Требования:
1. Количество комментариев вставленных в xml должно быть равно количеству тегов tagName.
2. Метод toXmlWithComment должен возвращать xml в виде строки преобразованной в соответствии с условием задачи.
3. Метод toXmlWithComment не должен изменять входящий xml в случае, если искомый тег отсутствует в нём.
4. Метод toXmlWithComment должен быть статическим.
5. Метод toXmlWithComment должен быть публичным.


*/

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
Комментарий внутри xml
*/
public class Solution {

    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        // Создаю документ DOM из объекта в аргументе:
        Document document = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.newDocument();

            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, document);
            document.getDocumentElement().normalize();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // достаю root узел
        Node root = document.getDocumentElement();

        // создаю новый объект комментария на основе присланного аргумента String comment:
        Comment commentNode = document.createComment(comment);

        // отправляю все в дополнительный метод для обработки
        addComment(document, root, tagName, commentNode);

        // еще один метод для конвертации измененного документа DOM в строку
        String result = null;
        try {
            result = convertDOMtoXML(document);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    // Основной вспомогательный метод – тут самое главное
    public static void addComment(Document doc, Node startNode, String tag, Comment cmnt) {

        //Перебираем все узлы, начиная с root
        // Способ итерации подсмотрел в инете: при такой итерации
        // можно удалять и добавлять узлы без выброса исключений
        for (Node node = startNode.getFirstChild(); node != null;) {
            Node nextNode = node.getNextSibling();

            // Проверяем таг на соответствие и добавляем комментарий перед ним, если да
            if (node.getNodeName().equals(tag)) {
                Element el = (Element) node;
                el.getParentNode().insertBefore(cmnt, node);
            }

            // Проверяем таг на наличие запрещенных символов "'<>^
            // и оборачиваем все в CDATA, если есть такой символ
            // Для проверки наличия используем еще один вспомогательный метод hasCDATA()
            // Также ввел вторым условием проверку на тип узла, потому что иначе сует по 2 раза в каждый таг
            if ((hasCDATA(node.getTextContent())) && (node.getNodeType() == 1)) {

                // Достаем исходное текстовое содержание из узла
                String stringToConvert = node.getTextContent();

                // Создаем объект CDATA, обнуляем текстовое содержимое внутри тага, засовываем в таг новый узел
                CDATASection cdata = doc.createCDATASection(stringToConvert);
                node.setTextContent("");
                node.appendChild(cdata);

            }

            // Рекурсия для того, чтобы обойти все вложенные таги во всю глубину
            if (node.hasChildNodes()) {
                addComment(doc, node, tag, cmnt);
            }

            // Это кусочек итерации в конце, все остальное в начале
            node = nextNode;
        }
    }


    // Вспомогательный метод для проверки наличия запрещенных символов " ' < > &
    public static boolean hasCDATA(String check) {

        Pattern p = Pattern.compile("[\"\'<>&]");
        Matcher m = p.matcher(check);
        if (m.find()) {
            return true;
        }
        return false;
    }


    // Вспомогательный метод для конвертации документа в строку:
    public static String convertDOMtoXML(Document DOMDocument) throws Exception {

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");


        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        DOMSource source = new DOMSource(DOMDocument);
        transformer.transform(source, result);
        return writer.toString();
    }



    public static void main(String[] args) {
        // Проверочный код
//        Dog dog = new Dog();
//        dog.age = 5;
//        dog.dogName = "Sharik";
//        dog.owner = "Arnold";
//        dog.needCDATA = "need CDATA cause of > ---";
//        String x = toXmlWithComment(dog, "dogOwnerXML", "comment Ha-ha-ha-ha!");
//        System.out.println(x);
    }
}
