package ExamsPrep;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int[] sizeInput = Arrays.stream(kbInput.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int row = sizeInput[0];
        int col = sizeInput[1];

        int rowPos = 0;
        int colPos = 0;

        String[][] matrix = new String[row][col];

        fillTheMatrix(row,matrix,kbInput);


        for (int i = 0; i < matrix.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equalsIgnoreCase("B")){
                    rowPos = i;
                    colPos = j;
                    isFound = true;
                }
            }
            if (isFound)
                break;

        }

        int touchedOpponents = 0;
        int movesMade = 0;

        String command = kbInput.nextLine();
        while (!"Finish".equalsIgnoreCase(command)){

            switch (command){
                case "up":
                    if (isValid("up",rowPos,colPos,col,row)){
                        if (matrix[rowPos - 1][colPos].equalsIgnoreCase("P")){

                            matrix[rowPos - 1][colPos] = "B";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos - 1;
                            touchedOpponents++;
                            movesMade++;

                            if (touchedOpponents == 3){
                                System.out.println("Game over!");
                                System.out.printf("Touched opponents: %d Moves made: %d%n",touchedOpponents,movesMade);
                                return;
                            }
                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("O")) {
                            break;
                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("-")) {
                            matrix[rowPos - 1][colPos] = "B";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos - 1;
                            movesMade++;
                        }

                    }else {
                        break;
                    }
                    break;
                case "down":
                    if (isValid("down",rowPos,colPos,col,row)){
                        if (matrix[rowPos + 1][colPos].equalsIgnoreCase("P")){

                            matrix[rowPos + 1][colPos] = "B";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos + 1;
                            touchedOpponents++;
                            movesMade++;

                            if (touchedOpponents == 3){
                                System.out.println("Game over!");
                                System.out.printf("Touched opponents: %d Moves made: %d%n",touchedOpponents,movesMade);
                                return;
                            }
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("O")) {
                            break;
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("-")) {
                            matrix[rowPos + 1][colPos] = "B";
                            matrix[rowPos][colPos] = "-";
                            rowPos = rowPos + 1;
                            movesMade++;
                        }

                    }else {
                        break;
                    }
                    break;
                case "left":
                    if (isValid("left",rowPos,colPos,col,row)){
                        if (matrix[rowPos][colPos - 1].equalsIgnoreCase("P")){

                            matrix[rowPos][colPos - 1] = "B";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos - 1;
                            touchedOpponents++;
                            movesMade++;

                            if (touchedOpponents == 3){
                                System.out.println("Game over!");
                                System.out.printf("Touched opponents: %d Moves made: %d%n",touchedOpponents,movesMade);
                                return;
                            }
                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("O")) {
                            break;

                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("-")) {
                            matrix[rowPos][colPos - 1] = "B";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos - 1;
                            movesMade++;
                        }

                    }else {
                        break;
                    }
                    break;
                case "right":
                    if (isValid("right",rowPos,colPos,col,row)){
                        if (matrix[rowPos][colPos + 1].equalsIgnoreCase("P")){

                            matrix[rowPos][colPos + 1] = "B";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos + 1;
                            touchedOpponents++;
                            movesMade++;

                            if (touchedOpponents == 3){
                                System.out.println("Game over!");
                                System.out.printf("Touched opponents: %d Moves made: %d%n",touchedOpponents,movesMade);
                                return;
                            }
                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("O")) {
                            break;

                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("-")) {
                            matrix[rowPos][colPos + 1] = "B";
                            matrix[rowPos][colPos] = "-";
                            colPos = colPos + 1;
                            movesMade++;
                        }

                    }else {
                        break;
                    }
                    break;
            }

            command = kbInput.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n",touchedOpponents,movesMade);



    }

    private static void fillTheMatrix(int row, String[][] matrix, Scanner kbInput) {
        for (int i = 0; i < row; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split(" ")).toArray(String[]::new);

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
