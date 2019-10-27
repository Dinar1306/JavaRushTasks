package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми

Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();    //D:\OneDrive7\OneDrive\JR\JavaRushTasks
        // "D:/OneDrive7/OneDrive/JR/JavaRushTasks/result.txt";//
        FileReader fileReader = new FileReader(file);
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = fileReader.read(); //читаем один символ (char будет расширен до int)
            sb.append((char)data); //пишем один символ (int будет обрезан/сужен до char)
        }
        /*
////////Вывод правильный, но не принимается////////////////////
        Document html = Jsoup.parse(sb.toString());
        Elements elements = html.getElementsByTag(args[0]);
        List<String> out = new ArrayList();
        for (Element el: elements
             ) {
            StringBuffer sbuf = new StringBuffer();
            int probelPosition = 0;
            sbuf.append(el.toString());
            int wrongProbel = sbuf.lastIndexOf(" </span");
            int dlinaStroki = sbuf.length();
            String temp = sbuf.substring(wrongProbel+1, dlinaStroki);
            if (wrongProbel == -1){
                out.add(temp);
            } else out.add((sbuf.substring(0, wrongProbel) + temp));
        }
        for (String st: out
             ) {
            System.out.println(st);
        }

//////////////////////////////////////////////////////////////////////////
        */
        Document document = Jsoup.parse(sb.toString(), "", Parser.xmlParser());
        Elements elem = document.select(args[0]);
        for (Element elements : elem){
            System.out.println(elements);
        }

        fileReader.close();
        reader.close();
    }
}
