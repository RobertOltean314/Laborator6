package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, Integer> countsHowMany(File file) {
        Map<String, Integer> counts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (counts.containsKey(word)) {
                        counts.put(word, counts.get(word) + 1);
                    } else {
                        counts.put(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counts;
    }

    public static void afiseaza(Map<String, Integer> deCateOriApare) {
        for (Map.Entry<String, Integer> entry : deCateOriApare.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\Paradigme de Programare\\Paradigme\\Laborator6\\src\\fisier.txt");

        afiseaza(countsHowMany(file));
    }
}