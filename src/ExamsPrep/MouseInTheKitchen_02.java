package ExamsPrep;

import java.util.*;
import java.util.stream.Collectors;

public class MouseInTheKitchen_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int[] size = Arrays.stream(kbInput.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int row = size[0];
        int col = size[1];

        String[][] matrix = new String[row][col];

        fillTheMatrix(row,matrix,kbInput);

       int rowPos = 0;
       int colPos = 0;

        for (int i = 0; i < matrix.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equalsIgnoreCase("M")){
                    rowPos = i;
                    colPos = j;
                    isFound = true;
                }
                if (isFound)
                    break;
            }
        }

        int counter = 0;
        for (String[] row1 : matrix) {
            for (String element : row1){

                if (element.equalsIgnoreCase("C")){
                    counter++;
                }
            }

        }


        String command = kbInput.nextLine();

        while (!command.equalsIgnoreCase("danger")){

            switch (command){
                case "up":
                if (isValid("up",rowPos,colPos,col,row)){
                    if (matrix[rowPos - 1 ][colPos].equalsIgnoreCase("C")){
                        counter--;
                        matrix[rowPos - 1][colPos] = "M";
                        matrix[rowPos][colPos] = "*";
                        rowPos = rowPos - 1;

                        if (counter == 0){
                            System.out.println("Happy mouse! All the cheese is eaten, good night!");
                            printMatrix(matrix);
                            return;
                        }
                    } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("T")) {

                        matrix[rowPos - 1][colPos] = "M";
                        matrix[rowPos][colPos] = "*";
                        rowPos = rowPos - 1;

                        System.out.println("Mouse is trapped!");
                        printMatrix(matrix);
                        return;

                    } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("@")) {

                        command = kbInput.nextLine();
                        continue;

                    } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("*")) {
                        matrix[rowPos - 1][colPos] = "M";
                        matrix[rowPos][colPos] = "*";
                        rowPos = rowPos - 1;
                    }

                }else {
                    System.out.println("No more cheese for tonight!");
                    printMatrix(matrix);
                    return;
                }
                break;
                case "down":
                    if (isValid("down",rowPos,colPos,col,row)){

                        if (matrix[rowPos + 1 ][colPos].equalsIgnoreCase("C")){
                            counter--;
                            matrix[rowPos + 1][colPos] = "M";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos + 1;

                            if (counter == 0){
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                printMatrix(matrix);
                                return;
                            }
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("T")) {

                            matrix[rowPos + 1][colPos] = "M";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos + 1;

                            System.out.println("Mouse is trapped!");
                            printMatrix(matrix);
                            return;
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("@")) {

                            command = kbInput.nextLine();
                            continue;

                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("*")) {
                            matrix[rowPos + 1][colPos] = "M";
                            matrix[rowPos][colPos] = "*";
                            rowPos = rowPos + 1;

                        }

                    }else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "left":
                    if (isValid("left",rowPos,colPos,col,row)){
                        if (matrix[rowPos][colPos - 1].equalsIgnoreCase("C")){
                            counter--;
                            matrix[rowPos][colPos - 1] = "M";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos - 1;

                            if (counter == 0){
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                printMatrix(matrix);
                                return;
                            }
                        } else if (matrix[rowPos][colPos -1].equalsIgnoreCase("T")) {

                            matrix[rowPos][colPos - 1] = "M";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos - 1;

                            System.out.println("Mouse is trapped!");
                            printMatrix(matrix);
                            return;

                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("@")) {

                            command = kbInput.nextLine();
                            continue;

                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("*")) {
                            matrix[rowPos][colPos - 1] = "M";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos - 1;

                        }

                    }else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(matrix);
                        return;
                    }

                    break;
                case "right":
                    if (isValid("right",rowPos,colPos,col,row)){
                        if (matrix[rowPos][colPos + 1].equalsIgnoreCase("C")){
                            counter--;
                            matrix[rowPos][colPos + 1] = "M";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos + 1;

                            if (counter == 0){
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                printMatrix(matrix);
                                return;
                            }
                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("T")) {

                            matrix[rowPos][colPos + 1] = "M";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos + 1;

                            System.out.println("Mouse is trapped!");
                            printMatrix(matrix);
                            return;
                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("@")) {

                            command = kbInput.nextLine();
                            continue;

                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("*")) {
                            matrix[rowPos][colPos + 1] = "M";
                            matrix[rowPos][colPos] = "*";
                            colPos = colPos + 1;

                        }

                    }else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(matrix);
                        return;
                    }

                    break;


            }
            command = kbInput.nextLine();
        }

        if (counter> 0){
            System.out.println("Mouse will come back later!");
            printMatrix(matrix);
        }



    }

    private static void fillTheMatrix(int row, String[][] matrix, Scanner kbInput) {
        for (int i = 0; i < row; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split("")).toArray(String[]::new);

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

        return (row1 >= 0 && row1 < rowSize) && (col1 >=0 && col1 < colSize);
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
