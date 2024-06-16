/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csv;

import java.util.Scanner;

/**
 *
 * @author barto
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj ścieżkę do pliku CSV: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String outputFilePath = scanner.nextLine();

        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        PersonAnalyzer personAnalyzer = new PersonAnalyzer();

        PersonService personService = new PersonService(csvFileReader, csvFileWriter, personAnalyzer);
        personService.processCsv(inputFilePath, outputFilePath);
    }
}
