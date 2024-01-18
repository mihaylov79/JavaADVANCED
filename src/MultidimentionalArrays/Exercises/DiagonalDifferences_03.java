package MultidimentionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifferences_03 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int matrixSize = Integer.parseInt(kbInput.nextLine());

        int [][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
    }
}
