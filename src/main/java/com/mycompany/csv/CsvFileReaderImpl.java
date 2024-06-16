/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


/**
 *
 * @author barto
 */
public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<Person> readCsv(String filePath) {
        List<Person> people = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (String[] record : records) {
                String firstName = record[0];
                String lastName = record[1];
                int age = Integer.parseInt(record[2]);
                String email = record[3];
                people.add(new Person(firstName, lastName, age, email));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return people;
    }
    
}
