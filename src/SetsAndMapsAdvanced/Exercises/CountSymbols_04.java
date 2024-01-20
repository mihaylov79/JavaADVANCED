package SetsAndMapsAdvanced.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        String input = kbInput.nextLine();

        Map<Character,Integer> line = new TreeMap<>();

        char[]inputChars = input.toCharArray();

        for (int i = 0; i < inputChars.length; i++) {

            if (line.containsKey(inputChars[i])){
                line.put(inputChars[i], line.get(inputChars[i])+ 1);

            }else {
                line.put(inputChars[i],1);
            }

        }

        line.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));

//        for (Map.Entry<Character,Integer> entry: line.entrySet()){
//
//            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
//        }



    }
}
