package MultidimentionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum_04 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        String dimensions = kbInput.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        int [][] matrix = new int[rows][cols];

        fillTheMatrix(matrix, kbInput);

        int sum;
        int bestSum = 0;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols -2 ; col++) {

                int matrixStart = matrix[row][col];

                sum = matrixStart + matrix[row][col +1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1 ][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row +2][col + 1] +  matrix[row + 2][col +2];

                if (sum > bestSum){
                    bestSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        for (int i = startRow; i <= startRow + 2 ; i++) {
            for (int j = startCol; j <= startCol + 2 ; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void fillTheMatrix(int[][] matrix, Scanner kbInput) {
        for (int row = 0; row < matrix.length ; row++) {

            int[] arr = Arrays.stream(kbInput.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;


        }
    }
}
