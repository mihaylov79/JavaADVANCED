package DeffiningClasses.Exersices.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int personQuantity = Integer.parseInt(kbInput.nextLine());
        List<Person> personList = new ArrayList<>();


        for (int i = 0; i < personQuantity; i++) {

            Person person = new Person(kbInput.nextLine().split("\\s+")[0],
                    Integer.parseInt(kbInput.nextLine().split("\\s+")[1]) );

            personList.add(person);

        }

        personList.stream().filter(person -> person.getAge() > 30).forEach(System.out::println);

    }


}
