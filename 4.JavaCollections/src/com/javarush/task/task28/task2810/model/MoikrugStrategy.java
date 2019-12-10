package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    //private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+Dnepropetrovsk";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";
                                           //https://moikrug.ru/vacancies?q=java&city_id=678&page=2&type=all
    private static final String URL_FORMAT= "https://moikrug.ru/vacancies?q=java&city_id=%d&page=%d&type=all";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:66.0)";
    //city_id=740  Уфа
    //city_id=678  Москва
    private int citi_id;

    @Override
    public List<Vacancy> getVacancies(String searchString)  {
        List<Vacancy> vacancies = new ArrayList<>();
        if (searchString == null)
            return Collections.emptyList();

        switch (searchString){
            case  ("Москва"):
                citi_id=678;
                break;
            case ("Уфа"):
                citi_id=740;
                break;
            default:
                citi_id=740; //Уфа по умолчанию
                break;
        }

        int j = 0;
        while (true) {
            try {
                //int x = j++;
                Document doc = getDocument(/*searchString,*/ citi_id, j++);
                Elements elements = doc.getElementsByClass("Job");
                if (elements.size() > 1){
                    for (int i = 0; i < elements.size(); i++) {
                        String siteName = "https://moikrug.ru";
                        Vacancy vacancy = new Vacancy();

                        // title
                        String title = elements.get(i).getElementsByClass("title").first().text();
                        vacancy.setTitle(title);

                        // salary
                        String salary = elements.get(i).getElementsByClass("salary").text();
                        if (salary != null)
                            vacancy.setSalary(salary);
                        else vacancy.setSalary("");

                        // city
                        String city = elements.get(i).getElementsByClass("location").text();
                        if (city != null)
                            vacancy.setCity(city);
                        else vacancy.setCity("");

                        // companyName
                        String companyName = elements.get(i).getElementsByClass("company_name").first().text();
                        vacancy.setCompanyName(companyName);

                        // url;
                        String url = elements.get(i).getElementsByClass("title").first().child(0).attr("href");
                        vacancy.setUrl(siteName+url);

                        // siteNa
                        vacancy.setSiteName(siteName);

                        vacancies.add(vacancy);
                    }
                }
                else break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return vacancies;
    }

    protected Document getDocument(/*String searchString,*/ int city, int page) {

        String myURL = String.format(URL_FORMAT, /*searchString,*/ city, page);

        Document doc = null;
        try {
            doc = Jsoup.connect(myURL).
                    userAgent(USER_AGENT).
                    referrer("https://google.com").
                    get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
