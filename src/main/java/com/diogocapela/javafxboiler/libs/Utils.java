package com.diogocapela.javafxboiler.libs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    static public List<ArrayList<String>> getDataFromFile(String filePath) {
        List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] lineData = scanner.nextLine().split(";");
                ArrayList<String> line = new ArrayList<>();
                for (String item : lineData) {
                    line.add(item);
                }
                data.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

}
