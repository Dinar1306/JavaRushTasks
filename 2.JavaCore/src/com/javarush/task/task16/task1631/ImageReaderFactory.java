package com.javarush.task.task16.task1631;


import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes input) {
        ImageTypes getJPG = ImageTypes.JPG;
        ImageTypes getPNG = ImageTypes.PNG;
        ImageTypes getBMP = ImageTypes.BMP;
        if (getJPG.equals(input)) return new JpgReader();
        if (getPNG.equals(input)) return new PngReader();
        if (getBMP.equals(input)) return new BmpReader();
        else throw new IllegalArgumentException();
    }
}
