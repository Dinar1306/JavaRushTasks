package com.javarush.task.task18.task1828;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void main() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            ArrayList<String> products = new ArrayList<>();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while (fileReader.ready())
                products.add(fileReader.readLine());
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.fail("Ошибка!");
    }
}