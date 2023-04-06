import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            int ammountOfPersons = sc.nextInt();
            Persons[] person = new Persons[ammountOfPersons];
            for (int i = 0; i < ammountOfPersons; i++) {
                person[i] = new Persons();
                person[i].name = sc.next();
                person[i].surname = sc.next();
                person[i].age = sc.nextInt();
                person[i].childrens = sc.nextInt();
            }
            ArrayList<Persons> persons1 = new ArrayList<Persons>();
            persons1.addAll(List.of(person));
            persons1.sort(Comparator.comparing(Persons::toString));
            System.out.println(persons1);
            findBiggestParent(persons1);
            culcAverageAge(persons1);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public static void findBiggestParent(ArrayList<Persons> persons1) {
        persons1.sort(Comparator.comparing(Persons::getChildrens));
        System.out.println("Самые многодетные родители:");
        System.out.println(persons1.get(persons1.size() - 1));
        System.out.println(persons1.get(persons1.size() - 2));
    }
    public static void culcAverageAge(ArrayList<Persons> persons1){
        System.out.println("Средний возраст родителей с детьми:");
        int sumAge = 0;
        int sumPerson = 0;
        for (int i = 0; i < persons1.size(); i++) {
            if (persons1.get(i).childrens > 0) {
                sumAge += persons1.get(i).age;
                sumPerson++;
            }
        }
        int averageAge= sumAge/sumPerson;
        System.out.println(averageAge);

    }

    }





