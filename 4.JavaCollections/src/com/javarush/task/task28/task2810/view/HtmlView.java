package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.*;
import java.util.List;

public class HtmlView implements View{
    Controller controller;
    private final String filePath = "./4.JavaCollections/src/"+
                                    this.getClass().getPackage().getName().replace('.', '/')+
                                    "/vacancies.html";

    public void userCitySelectEmulationMethod() {
        try {
            controller.onCitySelect("Уфа");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        File in = new File(filePath);
        return Jsoup.parse(in, "UTF-8");
    }

    /*
     * Метод формирует новое тело файла vacancies.html,
     * которое будет содержать вакансии, вывод в ввиде строки
     * условие 15
     *
     * @return тстрока, содержащая тело файла
     */
    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();
            Element templateVacancyByElement = document
                    .getElementsByClass("template").first();
            Element patternVacancyByElement = templateVacancyByElement.clone();
            patternVacancyByElement
                    .removeClass("template")
                    .removeAttr("style");
            document
                    .getElementsByAttributeValueEnding("class", "vacancy")
                    .remove();

            for (Vacancy vacancy : vacancies) {
                Element currentElement = patternVacancyByElement.clone();

                currentElement
                        .getElementsByClass("city").first()
                        .text(vacancy.getCity());
                currentElement
                        .getElementsByClass("companyName").first()
                        .text(vacancy.getCompanyName());
                currentElement
                        .getElementsByClass("salary").first()
                        .text(vacancy.getSalary());
                //currentElement.getElementsByAttribute("siteName").first().text(vacancy.getSiteName());

                Element link = currentElement.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateVacancyByElement.before(currentElement.outerHtml());
            }

        } catch (Exception exp) {
            exp.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }

    private void updateFile(String s) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            writer.write(s);
            writer.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(List<Vacancy> vacancies) {

        updateFile(getUpdatedFileContent(vacancies));
        //System.out.println(vacancies.size());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
