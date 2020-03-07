package org.kb;

import java.util.*;
import java.util.stream.Collectors;

public class Dziennik {
    private List<Student> students = new ArrayList<>();


    public void dodajStudenta(Student student) {
        students.add(student);
    }

    public void usunStudenta(Student student) {
        students.remove(student);
    }

    public void usunStudentaPoNumerzeIndeksu(String index) {
        for (Student s : students) {
            if (s.getIndexNumber().equalsIgnoreCase(index)) {
                students.remove(s);
                break;
            }
        }
    }

    //      opcja 2
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getIndexNumber().equalsIgnoreCase(index)) {
//                students.remove(students);
//                i--;
//            }
//        }
//
//       opcja 3
//        Iterator<Student> it = students.iterator();
//        while (it.hasNext()) {
//            Student st = it.next();
//            if (st.getIndexNumber().equalsIgnoreCase(index)) {
//                it.remove();
//            }
//        }
//    }

    /*
     * zwróć studenta lub jeśli go nie ma zwróć null
     * @param index - numer indeksu szukanego studenta
     * @return - Optional z opakowanym studentem
     */
    public Optional<Student> zwrocStudenta(String index) {
        for (Student s : students) {
            if (s.getIndexNumber().equalsIgnoreCase(index)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> podajSredniaStudenta(String index) {
        Optional<Student> studentOptional = zwrocStudenta(index);
        if (studentOptional.isPresent()) {
            Student st = studentOptional.get();
            return Optional.of(st.obliczSrednia());
        }
        return Optional.empty();
    }


    public List<Student> podajStudentowZagrozonych(Double srednia) {
        return students.stream().filter(student -> student.obliczSrednia() <= 2.5).collect(Collectors.toList());
    }


    public List<Student> posortujStudentowPoIndeksie() {
        Collections.sort(students, new Comparator<Student>() {
            //  -1
            //   0
            //   1
            @Override
            public int compare(Student student1, Student student2) {
                Long s1 =Long.parseLong(student1.getIndexNumber());
                Long s2 =Long.parseLong(student2.getIndexNumber());

                return s1.compareTo(s2);  //  -1  0  1
            }
        });
        return students;
    }


    public void dodajOcene(String index, Double mark) {
        Optional<Student> studentOptional = zwrocStudenta(index);
        if (studentOptional.isPresent()) {
            Student st = studentOptional.get();
            st.getMarks().add(mark);
        }
        throw  new RuntimeException("Nie udało się odnaleźć studenta!");
    }

}
