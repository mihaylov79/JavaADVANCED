package MultidimentionalArrays.Exercises;

import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        String maxtrixSize = kbInput.nextLine();
        int rows = Integer.parseInt(maxtrixSize.split("\\s+")[0]);
        int cols = Integer.parseInt(maxtrixSize.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, kbInput);

        String commandInput = kbInput.nextLine();

        while (!"End".equalsIgnoreCase(commandInput)) {
            String command = commandInput.split(" ")[0];
            if ("swap".equals(command) && commandInput.split(" ").length == 5) {

                int currentRow = Integer.parseInt(commandInput.split(" ")[1]);
                int currentCol = Integer.parseInt(commandInput.split(" ")[2]);

                int newRow = Integer.parseInt(commandInput.split(" ")[3]);
                int newCol = Integer.parseInt(commandInput.split(" ")[4]);

                if (isValid(rows, cols, currentRow, currentCol) && isValid(rows, cols, newRow, newCol)) {

                    String currentElement = matrix[currentRow][currentCol];
                    String newElement = matrix[newRow][newCol];

                    matrix[currentRow][currentCol] = newElement;
                    matrix[newRow][newCol] = currentElement;

                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            commandInput = kbInput.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int rows, int cols, int row, int col) {

        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }

    private static void fillMatrix(String[][] matrix, Scanner kbInput) {
        for (int i = 0; i < matrix.length; i++) {

            String[] arr = kbInput.nextLine().split("\\s+");

            matrix[i] = arr;

        }
    }
}
