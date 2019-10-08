package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {

    @Override
    //возвращал true, если переданный файл директория или содержит в конце имени ".html" или ".htm" без учета регистра
    public boolean accept(File file) {
        if (file.isDirectory()) return true;
        else {
            if (file.getName().toLowerCase().endsWith(".html") || file.getName().toLowerCase().endsWith(".htm"))
                return true;
        }
        return false;
    }

    //Чтобы в окне выбора файла в описании доступных типов файлов отображался текст "HTML и HTM файлы"
    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
