package ExamsPrep;

import java.util.Arrays;
import java.util.Scanner;

public class TheGambler_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int size = Integer.parseInt(kbInput.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split("")).toArray(String[]::new);

        }

        int ammount = 100;

        int rowPos = 0;
        int colPos = 0;

        for (int i = 0; i < matrix.length; i++) {

            boolean isFound = false;
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equalsIgnoreCase("G")){

                    rowPos = i;
                    colPos = j;
                    isFound = true;
                }
            }
            if (isFound){
                break;
            }

        }

        String command = kbInput.nextLine();
        while (!"end".equalsIgnoreCase(command)){

            switch (command){

                case "up":
                if (isValid("up",rowPos,colPos,size,size)){

                    if(matrix[rowPos - 1][colPos].equalsIgnoreCase("W")){
                        ammount+=100;
                        matrix[rowPos - 1][colPos] = "G";
                        matrix[rowPos][colPos] = "-";
                        rowPos = rowPos - 1;
                    } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("P")) {
                        ammount-=200;
                        matrix[rowPos - 1][colPos] = "G";
                        matrix[rowPos][colPos] = "-";
                        rowPos = rowPos - 1;
                    } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("J")) {
                        ammount+= 100_000;
                        matrix[rowPos - 1][colPos] = "G";
                        matrix[rowPos][colPos] = "-";
                        rowPos = rowPos - 1;

                        System.out.println("You win the Jackpot!");
                        System.out.printf("End of the game. Total amount: %d$%n",ammount);

                        printMatrix(matrix);

                        return;
                    }else if(matrix[rowPos - 1][colPos].equalsIgnoreCase("-")){
                        matrix[rowPos - 1][colPos] = "G";
                        matrix[rowPos][colPos] = "-";
                        rowPos = rowPos - 1;
                    }
                }else {
                    System.out.println("Game over! You lost everything!");
                    return;
                }
                    break;

                case "down":
                    if (isValid("down",rowPos,colPos,size,size)){

                        if(matrix[rowPos + 1][colPos].equalsIgnoreCase("W")){
                            ammount+=100;
                            matrix[rowPos + 1][colPos] = "G";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos + 1;
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("P")) {
                            ammount-=200;
                            matrix[rowPos + 1][colPos] = "G";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos + 1;
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("J")) {
                            ammount+= 100_000;
                            matrix[rowPos + 1][colPos] = "G";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos + 1;

                            System.out.println("You win the Jackpot!");
                            System.out.printf("End of the game. Total amount: %d$%n",ammount);

                            printMatrix(matrix);

                            return;

                        }else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("-")){
                            matrix[rowPos + 1][colPos] = "G";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos + 1;
                        }

                    }else {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }

                    break;
                case "left":
                    if (isValid("left",rowPos,colPos,size,size)){

                        if(matrix[rowPos][colPos - 1].equalsIgnoreCase("W")){
                            ammount+=100;
                            matrix[rowPos][colPos - 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos - 1;
                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("P")) {
                            ammount-=200;
                            matrix[rowPos][colPos - 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos - 1;
                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("J")) {
                            ammount+= 100_000;
                            matrix[rowPos][colPos - 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos - 1;

                            System.out.println("You win the Jackpot!");
                            System.out.printf("End of the game. Total amount: %d$%n",ammount);

                            printMatrix(matrix);

                            return;

                        }else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("-")){
                            matrix[rowPos][colPos - 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos - 1;
                        }

                    }else {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                    break;

                case "right":
                    if (isValid("right",rowPos,colPos,size,size)){

                        if(matrix[rowPos][colPos + 1].equalsIgnoreCase("W")){
                            ammount+=100;
                            matrix[rowPos][colPos + 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos + 1;
                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("P")) {
                            ammount-=200;
                            matrix[rowPos][colPos + 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos + 1;
                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("J")) {
                            ammount+= 100_000;
                            matrix[rowPos][colPos + 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos + 1;

                            System.out.println("You win the Jackpot!");
                            System.out.printf("End of the game. Total amount: %d$%n",ammount);

                            printMatrix(matrix);

                            return;

                        }else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("-")){
                            matrix[rowPos][colPos + 1] = "G";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos + 1;
                        }

                    }else {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }

                    break;

            }

            if (ammount <= 0){
                System.out.println("Game over! You lost everything!");
                return;
            }
            command = kbInput.nextLine();
        }

        if (command.equalsIgnoreCase("end")){
            System.out.printf("End of the game. Total amount: %d$%n",ammount);

            printMatrix(matrix);
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix){
            for (String element : row){

                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static boolean isValid(String command, int row, int col,int colSize,int rowSize){

        int row1=row;
        int col1 = col;

        switch (command){

            case "up":
                row1 = row - 1;
                break;
            case "down":
                row1 = row + 1;
                break;
            case "left":
                col1 = col - 1;
                break;
            case "right":
                col1 = col + 1;
        }

        return (row1 >= 0 && row1 < colSize) && (col1 >=0 && col1 < rowSize);
    }
}
