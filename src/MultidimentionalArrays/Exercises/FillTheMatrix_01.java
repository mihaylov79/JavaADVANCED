package MultidimentionalArrays.Exercises;

import java.util.Scanner;


public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        String input = kbInput.nextLine();
        int dim = Integer.parseInt(input.split(",\\s+")[0]);
        String patternType = input.split(",\\s+")[1];

        int [][] matrix = new int[dim][dim];

        switch (patternType){
            case "A":

                fillMatrixA(matrix);
                printMatrix(matrix);

                break;

            case "B":

                fillMatrixB(matrix);
                printMatrix(matrix);

                break;
        }

    }

    private static void fillMatrixB(int[][] matrix) {
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            if ((row + 1) % 2 != 0){
                for (int column = 0; column < matrix[row].length; column++) {
                    matrix[column][row] = count;
                    count++;
                }
            }else {
                for (int column = matrix[row].length - 1; column >= 0 ; column--) {
                    matrix[column][row] = count;
                    count++;
                }
            }
        }
    }

    private static void fillMatrixA(int[][] matrix) {
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length ; column++) {
                matrix[column][row] = count;
                count++;

            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
