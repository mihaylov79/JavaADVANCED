package ExamsPrep;

import java.util.Arrays;
import java.util.Scanner;

public class TheSquirrel_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int size = Integer.parseInt(kbInput.nextLine());
        int row = size;
        int col = size;

        int rowPos = 0;
        int colPos = 0;

        String[][] matrix = new String[row][col];

        String[] commandInput = kbInput.nextLine().split(", ");

        fillTheMatrix(row,matrix,kbInput);

        for (int i = 0; i < matrix.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equalsIgnoreCase("s")){
                    rowPos = i;
                    colPos = j;
                    isFound = true;
                }
            }
            if (isFound)
                break;
        }

        int hazelnutsCollected = 0;

        for (int i = 0; i < commandInput.length; i++) {

            String command = commandInput[i];

            switch (command){

                case "up":
                    if (isValid("up",rowPos,colPos,col,row)){
                        if (matrix[rowPos - 1][colPos].equalsIgnoreCase("h")){
                            hazelnutsCollected++;
                            matrix[rowPos - 1][colPos] = "s";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos - 1;

                            if (hazelnutsCollected == 3){
                                System.out.println("Good job! You have collected all hazelnuts!");
                                printCollectedHazelnuts(hazelnutsCollected);
                            }

                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("t")) {

                            matrix[rowPos - 1][colPos] = "s";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos - 1;

                            System.out.println("Unfortunately, the squirrel stepped on a trap...");
                            printCollectedHazelnuts(hazelnutsCollected);
                            return;
                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("*")) {

                            matrix[rowPos - 1][colPos] = "s";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos - 1;
                        }
                    }else {
                        System.out.println("The squirrel is out of the field.");
                        printCollectedHazelnuts(hazelnutsCollected);
                        return;
                    }
                    break;
                case "down":
                    if (isValid("down",rowPos,colPos,col,row)){
                        if (matrix[rowPos + 1][colPos].equalsIgnoreCase("h")){
                            hazelnutsCollected++;
                            matrix[rowPos + 1][colPos] = "s";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos + 1;

                            if (hazelnutsCollected == 3){
                                System.out.println("Good job! You have collected all hazelnuts!");
                                printCollectedHazelnuts(hazelnutsCollected);
                            }

                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("t")) {

                            matrix[rowPos + 1][colPos] = "s";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos + 1;

                            System.out.println("Unfortunately, the squirrel stepped on a trap...");
                            printCollectedHazelnuts(hazelnutsCollected);
                            return;
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("*")) {

                            matrix[rowPos + 1][colPos] = "s";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos + 1;
                        }
                    }else {
                        System.out.println("The squirrel is out of the field.");
                        printCollectedHazelnuts(hazelnutsCollected);
                        return;
                    }
                    break;
                case "left":
                    if (isValid("left",rowPos,colPos,col,row)){
                        if (matrix[rowPos][colPos - 1].equalsIgnoreCase("h")){
                            hazelnutsCollected++;
                            matrix[rowPos][colPos - 1] = "s";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos - 1;

                            if (hazelnutsCollected == 3){
                                System.out.println("Good job! You have collected all hazelnuts!");
                                printCollectedHazelnuts(hazelnutsCollected);
                            }

                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("t")) {

                            matrix[rowPos][colPos - 1] = "s";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos - 1;

                            System.out.println("Unfortunately, the squirrel stepped on a trap...");
                            printCollectedHazelnuts(hazelnutsCollected);
                            return;
                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("*")) {

                            matrix[rowPos][colPos - 1] = "s";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos - 1;
                        }
                    }else {
                        System.out.println("The squirrel is out of the field.");
                        printCollectedHazelnuts(hazelnutsCollected);
                        return;
                    }
                    break;
                case "right":
                    if (isValid("right",rowPos,colPos,col,row)){
                        if (matrix[rowPos][colPos + 1].equalsIgnoreCase("h")){
                            hazelnutsCollected++;
                            matrix[rowPos][colPos + 1] = "s";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos + 1;

                            if (hazelnutsCollected == 3){
                                System.out.println("Good job! You have collected all hazelnuts!");
                                printCollectedHazelnuts(hazelnutsCollected);
                            }

                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("t")) {

                            matrix[rowPos][colPos + 1] = "s";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos + 1;

                            System.out.println("Unfortunately, the squirrel stepped on a trap...");
                            printCollectedHazelnuts(hazelnutsCollected);
                            return;
                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("*")) {

                            matrix[rowPos][colPos + 1] = "s";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos + 1;
                        }
                    }else {
                        System.out.println("The squirrel is out of the field.");
                        printCollectedHazelnuts(hazelnutsCollected);
                        return;
                    }
                    break;
            }

        }

        if (hazelnutsCollected < 3){
            System.out.println("There are more hazelnuts to collect.");
            printCollectedHazelnuts(hazelnutsCollected);
        }










    }

    private static void printCollectedHazelnuts(int hazelnutsCollected) {
        System.out.printf("Hazelnuts collected: %d%n", hazelnutsCollected);
    }

    private static void fillTheMatrix(int row, String[][] matrix, Scanner kbInput) {
        for (int i = 0; i < row; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split("")).toArray(String[]::new);

        }
    }

    private static boolean isValid(String command, int rowPos, int colPos,int colSize,int rowSize){

        int row=rowPos;
        int col = colPos;

        switch (command){

            case "up":
                row = rowPos - 1;
                break;
            case "down":
                row = rowPos + 1;
                break;
            case "left":
                col = colPos - 1;
                break;
            case "right":
                col = colPos + 1;
        }

        return (row >= 0 && row < rowSize) && (col >=0 && col < colSize);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix){
            for (String element : row){

                System.out.print(element);
            }
            System.out.println();
        }
    }



}
