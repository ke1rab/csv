/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csv;

import java.util.List;

/**
 *
 * @author barto
 */
public class PersonService {
    private final CsvFileReader csvFileReader;
    private final CsvFileWriter csvFileWriter;
    private final PersonAnalyzer personAnalyzer;

    public PersonService(CsvFileReader csvFileReader, CsvFileWriter csvFileWriter, PersonAnalyzer personAnalyzer) {
        this.csvFileReader = csvFileReader;
        this.csvFileWriter = csvFileWriter;
        this.personAnalyzer = personAnalyzer;
    }

    public void processCsv(String inputFilePath, String outputFilePath) {
        List<Person> people = csvFileReader.readCsv(inputFilePath);
        double averageAge = personAnalyzer.calculateAverageAge(people);
        Person personWithLongestLastName = personAnalyzer.findPersonWithLongestLastName(people);
        List<Person> sortedPeople = personAnalyzer.sortPeopleByAgeDescending(people);

        StringBuilder result = new StringBuilder();
        result.append("Średni wiek: ").append(averageAge).append("\n");
        result.append("Osoba z najdłuższym nazwiskiem: ").append(personWithLongestLastName).append("\n");
        result.append("Osoby posortowane wg wieku malejąco:\n");
        for (Person person : sortedPeople) {
            result.append(person).append("\n");
        }

        csvFileWriter.writeToFile(outputFilePath, result.toString());
        System.out.println(result.toString());
    }
}
