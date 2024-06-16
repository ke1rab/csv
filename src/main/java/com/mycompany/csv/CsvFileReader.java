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
public interface CsvFileReader {
    List<Person> readCsv(String filePath);
}
