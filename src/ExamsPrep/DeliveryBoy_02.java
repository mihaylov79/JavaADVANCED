package ExamsPrep;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int[] matrixInput = Arrays.stream(kbInput.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int row = matrixInput[0];
        int col = matrixInput[1];

        String[][] matrix = new String[row][col];

        fillTheMatrix(row, matrix, kbInput);

        int[] coordinates = findPosition(matrix);

        int rowPos = coordinates[0];
        int colPos = coordinates[1];

        String command = kbInput.nextLine();

        while (true) {

            switch (command) {

                case "up":
                    if (isValid("up", rowPos, colPos, col, row)) {
                        if (matrix[rowPos - 1][colPos].equalsIgnoreCase("P")) {

                            matrix[rowPos - 1][colPos] = "R";
                            matrix[rowPos][colPos] = ".";
                            rowPos = rowPos - 1;

                            System.out.println("Pizza is collected. 10 minutes for delivery.");

                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("A")) {

                            matrix[rowPos - 1][colPos] = "P";
                            matrix[rowPos][colPos] = ".";
                            matrix[coordinates[0]][coordinates[1]] = "B";

                            System.out.println("Pizza is delivered on time! Next order...");
                            printMatrix(matrix);
                            return;

                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("*")) {

                            break;

                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase("-")) {

                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            rowPos = rowPos - 1;

                        } else if (matrix[rowPos - 1][colPos].equalsIgnoreCase(".")) {

                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            rowPos = rowPos - 1;
                        }

                    } else {
                        if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                            matrix[rowPos][colPos] = ".";
                        }
                        matrix[coordinates[0]][coordinates[1]] = " ";

                        System.out.println("The delivery is late. Order is canceled.");
                        printMatrix(matrix);
                        return;

                    }
                    break;
                case "down":
                    if (isValid("down", rowPos, colPos, col, row)) {
                        if (matrix[rowPos + 1][colPos].equalsIgnoreCase("P")) {

                            matrix[rowPos + 1][colPos] = "R";
                            matrix[rowPos][colPos] = ".";
                            rowPos = rowPos + 1;

                            System.out.println("Pizza is collected. 10 minutes for delivery.");

                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("A")) {

                            matrix[rowPos + 1][colPos] = "P";
                            matrix[rowPos][colPos] = ".";
                            matrix[coordinates[0]][coordinates[1]] = "B";

                            System.out.println("Pizza is delivered on time! Next order...");
                            printMatrix(matrix);
                            return;

                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("*")) {

                            break;

                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase("-")) {

                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            rowPos = rowPos + 1;

                        } else if (matrix[rowPos + 1][colPos].equalsIgnoreCase(".")) {

                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            rowPos = rowPos + 1;
                        }

                    } else {
                        if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                            matrix[rowPos][colPos] = ".";
                        }
                        matrix[coordinates[0]][coordinates[1]] = " ";

                        System.out.println("The delivery is late. Order is canceled.");
                        printMatrix(matrix);
                        return;
                    }
                    break;

                case "left":
                    if (isValid("left", rowPos, colPos, col, row)) {
                        if (matrix[rowPos][colPos - 1].equalsIgnoreCase("P")) {

                            matrix[rowPos][colPos - 1] = "R";
                            matrix[rowPos][colPos] = ".";
                            colPos = colPos - 1;

                            System.out.println("Pizza is collected. 10 minutes for delivery.");

                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("A")) {

                            matrix[rowPos][colPos - 1] = "P";
                            matrix[rowPos][colPos] = ".";
                            matrix[coordinates[0]][coordinates[1]] = "B";

                            System.out.println("Pizza is delivered on time! Next order...");
                            printMatrix(matrix);
                            return;

                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("*")) {

                            break;

                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase("-")) {

                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            colPos = colPos - 1;
                        } else if (matrix[rowPos][colPos - 1].equalsIgnoreCase(".")) {

                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            colPos = colPos - 1;
                        }

                    } else {
                        if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                            matrix[rowPos][colPos] = ".";
                        }
                        matrix[coordinates[0]][coordinates[1]] = " ";

                        System.out.println("The delivery is late. Order is canceled.");
                        printMatrix(matrix);
                        return;
                    }
                    break;

                case "right":
                    if (isValid("right", rowPos, colPos, col, row)) {
                        if (matrix[rowPos][colPos + 1].equalsIgnoreCase("P")) {

                            matrix[rowPos][colPos + 1] = "R";
                            matrix[rowPos][colPos] = ".";
                            colPos = colPos + 1;

                            System.out.println("Pizza is collected. 10 minutes for delivery.");

                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("A")) {

                            matrix[rowPos][colPos + 1] = "P";
                            matrix[rowPos][colPos] = ".";

                            matrix[coordinates[0]][coordinates[1]] = "B";

                            System.out.println("Pizza is delivered on time! Next order...");
                            printMatrix(matrix);
                            return;

                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("*")) {

                            break;

                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase("-")) {

                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            colPos = colPos + 1;

                        } else if (matrix[rowPos][colPos + 1].equalsIgnoreCase(".")) {
                            if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                                matrix[rowPos][colPos] = ".";
                            }
                            colPos = colPos + 1;
                        }

                    } else {
                        if (!"R".equalsIgnoreCase(matrix[rowPos][colPos])) {
                            matrix[rowPos][colPos] = ".";
                        }
                        matrix[coordinates[0]][coordinates[1]] = " ";

                        System.out.println("The delivery is late. Order is canceled.");
                        printMatrix(matrix);
                        return;
                    }
                    break;
            }
            command = kbInput.nextLine();
        }

    }

    private static int[] findPosition(String[][] matrix) {
        int rowPos = 0;
        int colPos = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equalsIgnoreCase("B")) {

                    rowPos = i;
                    colPos = j;
                    isFound = true;
                }
            }
            if (isFound)
                break;
        }
        int[] position = new int[2];
        position[0] = rowPos;
        position[1] = colPos;
        return position;
    }

    private static void fillTheMatrix(int row, String[][] matrix, Scanner kbInput) {
        for (int i = 0; i < row; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split("")).toArray(String[]::new);

        }
    }

    private static boolean isValid(String command, int rowPos, int colPos, int colSize, int rowSize) {

        int row = rowPos;
        int col = colPos;

        switch (command) {

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

        return (row >= 0 && row < rowSize) && (col >= 0 && col < colSize);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {

                System.out.print(element);
            }
            System.out.println();
        }
    }
}
