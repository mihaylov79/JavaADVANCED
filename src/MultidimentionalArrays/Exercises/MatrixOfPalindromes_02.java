package MultidimentionalArrays.Exercises;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        String matrixSize = kbInput.nextLine();

        int rows = Integer.parseInt(matrixSize.split("\\s+")[0]);
        int cols = Integer.parseInt(matrixSize.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        generateMatrix(rows, cols, matrix);

        printMatrix(matrix);
    }

    private static void generateMatrix(int rows, int cols, String[][] matrix) {
        char a = 'a';
        char b = 'a';

        for (int row = 0; row < rows; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols; col++) {

                sb.append(a);
                sb.append(b);
                sb.append(a);
                b++;

                String sbString = sb.toString();

                matrix[row][col] = sbString;

                sb.setLength(0);
            }
            System.out.println(" ");

            a++;
            b = a;
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
}
