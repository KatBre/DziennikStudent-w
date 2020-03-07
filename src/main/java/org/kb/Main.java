package org.kb;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("123", "Jan", "Kowalski");
        Student s2 = new Student("456", "Adam", "Nowak");
        Student s3 = new Student("345", "Zofia", "Cebula");
        Student s4 = new Student("234", "Anna", "Zięba");
        Student s5 = new Student("567", "Jerzy", "Wiaderko");
        Dziennik klasa1 = new Dziennik();
        klasa1.dodajStudenta(s1);
        klasa1.dodajStudenta(s2);
        klasa1.dodajStudenta(s3);
        klasa1.dodajStudenta(s4);
        klasa1.dodajStudenta(s5);
        klasa1.usunStudenta(s3);
        klasa1.usunStudentaPoNumerzeIndeksu("234");
        System.out.println();
        Optional<Student> pudelko = klasa1.zwrocStudenta("456");
        if (pudelko.isPresent()) {
            Student s = pudelko.get();
            System.out.println(s.getName());
        }

//        klasa1.posortujStudentowPoIndeksie().forEach(s -> System.out.println(s));
        klasa1.posortujStudentowPoIndeksie().forEach(System.out::println);


    }
}
