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

            String inputData = kbInput.nextLine();

            String name = inputData.split("\\s+")[0];
            int age = Integer.parseInt(inputData.split("\\s+")[1]);

            Person person = new Person(name,age);

            personList.add(person);

        }

        personList.stream().filter(person -> person.getAge() > 30)
                          .sorted().forEach(System.out::println);

    }


}
