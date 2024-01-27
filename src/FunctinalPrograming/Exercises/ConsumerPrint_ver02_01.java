package FunctinalPrograming.Exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_ver02_01 {
    public static void main(String[] args) {

        Scanner kbInput = new Scanner(System.in);

        Consumer<String>print = System.out::println;

        String[] nameInput = kbInput.nextLine().split("\\s+");

        for (String s : nameInput) {
            print.accept(s);
        }
    }
}
