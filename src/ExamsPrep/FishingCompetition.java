package ExamsPrep;

import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {


        Scanner kbInput = new Scanner(System.in);

        int fishingAreaSize = Integer.parseInt(kbInput.nextLine());

        String[][] matrix = new String[fishingAreaSize][fishingAreaSize];

        fillMatrix(matrix, kbInput);

        int boatPosR = 0;
        int boatPosC = 0;
        int fishcaught = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col].equals("S")) {
                    boatPosR = row;
                    boatPosC = col;

                }
            }
        }

        String command = kbInput.nextLine();
        while (!"collect the nets".equalsIgnoreCase(command)) {

            switch (command) {
                case "left":
                    if (boatPosC - 1 >= 0) {
                        if (matrix[boatPosR][boatPosC - 1].equalsIgnoreCase("W")) {
                            int wpC = boatPosC - 1;
                            printWhirlpoolMsg(boatPosR, wpC);
                            return;
                        }
                        if (!matrix[boatPosR][boatPosC - 1].equalsIgnoreCase("-")) {
                            fishcaught += Integer.parseInt(matrix[boatPosR][boatPosC - 1]);

                        }
                        matrix[boatPosR][boatPosC - 1] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosC = boatPosC - 1;
                    } else {
                        if (!matrix[boatPosR][fishingAreaSize - 1].equalsIgnoreCase("-")) {
                            fishcaught += Integer.parseInt(matrix[boatPosR][fishingAreaSize - 1]);

                        }
                        matrix[boatPosR][fishingAreaSize - 1] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosC = fishingAreaSize - 1;

                    }

                    break;
                case "right":

                    if (boatPosC + 1 < fishingAreaSize) {
                        if (matrix[boatPosR][boatPosC + 1].equalsIgnoreCase("W")) {
                            int wpC = boatPosC + 1;
                            printWhirlpoolMsg(boatPosR, wpC);
                            return;
                        }
                        if (!matrix[boatPosR][boatPosC + 1].equalsIgnoreCase("-")) {
                            fishcaught += Integer.parseInt(matrix[boatPosR][boatPosC + 1]);


                        }
                        matrix[boatPosR][boatPosC + 1] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosC = boatPosC + 1;
                    } else {
                        if (!matrix[boatPosR][0].equals("-")) {
                            fishcaught += Integer.parseInt(matrix[boatPosR][0]);

                        }
                        matrix[boatPosR][0] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosC = 0;
                    }

                    break;
                case "up":

                    if (boatPosR - 1 >= 0) {
                        if (matrix[boatPosR - 1][boatPosC].equalsIgnoreCase("W")) {
                            int wpR = boatPosR - 1;
                            printWhirlpoolMsg(wpR, boatPosC);
                            return;
                        }

                        if (!matrix[boatPosR - 1][boatPosC].equalsIgnoreCase("-")) {
                            fishcaught += Integer.parseInt(matrix[boatPosR - 1][boatPosC]);
                        }
                        matrix[boatPosR - 1][boatPosC] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosR = boatPosR - 1;

                    } else {
                        if (!matrix[matrix.length - 1][boatPosC].equalsIgnoreCase("-")) {
                            fishcaught += Integer.parseInt(matrix[matrix.length - 1][boatPosC]);

                        }
                        matrix[matrix.length - 1][boatPosC] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosR = matrix.length - 1;
                    }

                    break;
                case "down":

                    if (boatPosR + 1 < matrix.length) {
                        if (matrix[boatPosR + 1][boatPosC].equalsIgnoreCase("W")) {
                            int wpR = boatPosR + 1;
                            printWhirlpoolMsg(wpR, boatPosC);
                            return;
                        }
                        if (!matrix[boatPosR + 1][boatPosC].equalsIgnoreCase("-")) {
                            fishcaught += Integer.parseInt(matrix[boatPosR + 1][boatPosC]);
                        }
                        matrix[boatPosR + 1][boatPosC] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosR = boatPosR + 1;


                    } else {
                        if (!matrix[0][boatPosC].equalsIgnoreCase("-")) {
                            fishcaught += Integer.parseInt(matrix[0][boatPosC]);

                        }
                        matrix[0][boatPosC] = "S";
                        matrix[boatPosR][boatPosC] = "-";
                        boatPosR = 0;
                    }
                    break;
            }
            command = kbInput.nextLine();
        }

        if (fishcaught > 19) {
            System.out.println("Success! You managed to reach the quota!");
            System.out.printf("Amount of fish caught: %d tons.%n", fishcaught);
            printMatrix(matrix);
        }
        if (fishcaught < 20) {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - fishcaught);
            if (fishcaught > 0) {
                System.out.printf("Amount of fish caught: %d tons.%n", fishcaught);
            }
            printMatrix(matrix);
        }

//        System.out.println(fishcaught);
//
//        printMatrix(matrix);

    }

    private static void printWhirlpoolMsg(int wpR, int wpC) {
        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught." +
                " Last coordinates of the ship: [%d,%d]", wpR, wpC);
    }

//    private static void findTheBoat(String[][] matrix) {
//        int boatPosR;
//        int boatPosC;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//
//                if (matrix[row][col].equals("S")){
//                    boatPosR = row;
//                    boatPosC = col;
//                }
//
//            }
//
//        }
//    }

    private static void fillMatrix(String[][] matrix, Scanner kbInput) {
        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = kbInput.nextLine().split("");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String elem : strings) {
                System.out.print(elem);
            }
            System.out.println();
        }
    }
}
