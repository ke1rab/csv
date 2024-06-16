/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csv;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author barto
 */
public class PersonAnalyzer {
     public double calculateAverageAge(List<Person> people) {
        return people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public Person findPersonWithLongestLastName(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingInt(person -> person.getLastName().length()))
                .orElse(null);
    }

    public List<Person> sortPeopleByAgeDescending(List<Person> people) {
        people.sort(Comparator.comparingInt(Person::getAge).reversed());
        return people;
    }
}
