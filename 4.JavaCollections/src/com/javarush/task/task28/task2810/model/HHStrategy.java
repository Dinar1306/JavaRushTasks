package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Этот класс будет реализовывать конкретную стратегию работы с сайтом ХэдХантер (http://hh.ua/ и http://hh.ru/).
public class HHStrategy implements Strategy {
    //private static final String URL_FORMAT = "http://ufa.hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    String url = String.format(URL_FORMAT, "Уфа", 1);
    private static final String userAgent = "Mozilla/5.0 (jsoup)";
//  private static final int timeout = 2 * 500;
 //   private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html?text=java+%s&page=%d";
    String ADDITIONAL_VALUE;
    int PAGE_VALUE = 0;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        Document document = null;
        try {
            document = getDocument(searchString, PAGE_VALUE);
            while (true) {
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0) {
                    PAGE_VALUE = 0;
                    break;
                }
                for (Element element : elements) {
                    if (element != null) {
                        Vacancy vac = new Vacancy();
//                        //У каждой вакансии должно быть заполнено поле title полученными из html-элемента данными о названии вакансии
                        vac.setTitle(element.getElementsByAttributeValueContaining("data-qa", "title").text().trim());

                        vac.setCity(element.getElementsByAttributeValueContaining("data-qa", "address").text().trim());
                        vac.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text().trim());
                        vac.setSiteName(URL_FORMAT);
                        String urlPage = element.getElementsByAttributeValueContaining("data-qa", "title").attr("href").trim();
                        vac.setUrl(urlPage);
                        String salary = element.getElementsByAttributeValueContaining("data-qa", "compensation").text().trim();
                        vac.setSalary(salary.length()==0 ? "" : salary);
                        result.add(vac);

                    }
                }
                ++PAGE_VALUE;
                if (PAGE_VALUE==99) break;
                document = getDocument(searchString, PAGE_VALUE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {

        String myURL = String.format(URL_FORMAT, searchString, page);

        Document doc = null;
        try {
            doc = Jsoup.connect(myURL).
                    userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/11.1.1 Safari/605.1.15").
                    referrer("").
                    get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
