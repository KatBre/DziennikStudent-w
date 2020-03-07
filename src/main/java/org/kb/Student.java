package org.kb;



import lombok.*;

import java.util.ArrayList;
import java.util.List;


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

}
