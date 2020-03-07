package org.kb;



import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;


@Data
@Getter
@Setter
@NoArgsConstructor
public class Student {
    private List<Double> marks = new ArrayList<>();
    private String indexNumber;
    private String name;
    private String surname;

    public Student(String indexNumber, String name, String surname) {
        this.indexNumber = indexNumber;
        this.name = name;
        this.surname = surname;
    }

    public Double obliczSrednia() {
        double sum = 0.0;
        for (int i = 0; i < marks.size() ; i++) {
            sum += marks.get(i);
        }
//        opcja 2
//        sum = marks.stream().mapToDouble(Double::doubleValue).sum();
//
//        opcja 3 (od razu daje wynik)
//        Optional<Double>
        OptionalDouble srednia = marks.stream().mapToDouble(Double::doubleValue).average();
        return srednia.orElse(0.0);
//        return sum / marks.size();
    }

}
