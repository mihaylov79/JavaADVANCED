package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Map<String,String> list = new LinkedHashMap<>();

        String name = kbInput.nextLine();


        while (!"stop".equalsIgnoreCase(name)){
            String mail = kbInput.nextLine();

            list.putIfAbsent(name, mail);

            name = kbInput.nextLine();


        }

        for (Map.Entry<String,String>entry: list.entrySet()){

            if (!entry.getValue().contains(".uk") && !entry.getValue().contains(".com")
                    && !entry.getValue().contains(".us")){
                System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
            }
        }


    }
}
