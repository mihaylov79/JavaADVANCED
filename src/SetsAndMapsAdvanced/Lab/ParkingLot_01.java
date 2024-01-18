package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {

        Scanner kbInput = new Scanner(System.in);

        String input = kbInput.nextLine();

        Set<String> lot = new LinkedHashSet<>();

        while (!"END".equalsIgnoreCase(input)){

            String command = input.split(",\\s+")[0];
            String regNumber = input.split(",\\s+")[1];

            switch (command){
                case "IN":
                    lot.add(regNumber);
                    break;
                case "OUT":
                    lot.remove(regNumber);
                    break;
            }

            input = kbInput.nextLine();
        }

        if (lot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            lot.forEach(System.out::println);

        }





    }
}
