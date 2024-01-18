package MultidimentionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifferences_03 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int matrixSize = Integer.parseInt(kbInput.nextLine());

        int [][] matrix = new int[matrixSize][matrixSize];

        int pDiagSum = 0;
        int sDiagSum = 0;

        fillMatrix(matrix, kbInput);

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length ; col++) {

                if (row == col){
                    pDiagSum += matrix[row][col] ;
                }
                if (col == (matrix[row].length - 1) - row ){
                    sDiagSum += matrix[row][col];
                }
            }

        }

        System.out.println(Math.abs(pDiagSum - sDiagSum));
    }

    private static void fillMatrix(int[][] matrix, Scanner kbInput) {
        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
    }
}
