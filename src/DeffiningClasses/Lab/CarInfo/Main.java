package DeffiningClasses.Lab.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);
        int entries = Integer.parseInt(kbInput.nextLine());

        for (int i = 0; i < entries; i++) {

            String[] input = kbInput.nextLine().split("\\s+");

            if (input.length == 1){

                Car car = new Car(input[0]);
                car.setBrand(input[0]);

                print(car);

            }else {
                String brand = input[0];
                String model = input[1];
                int horsepower = Integer.parseInt(input[2]);

                Car car = new Car(brand,model,horsepower);

                car.setBrand(brand);
                car.setModel(model);
                car.setHorsepower(horsepower);

                print(car);
            }

        }


    }

    private static void print(Car car) {
        System.out.println(car.carInfo());
    }
}
