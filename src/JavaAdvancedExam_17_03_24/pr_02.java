package JavaAdvancedExam_17_03_24;

import java.util.Arrays;
import java.util.Scanner;

public class pr_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int size = Integer.parseInt(kbInput.nextLine());

        int row = size;
        int col = size;

        String[][] matrix = new String[row][col];

        fillTheMatrix(row,matrix,kbInput);

        int[] position = findPosition(matrix);
        int enemyCount = findEnemiesCount(matrix);

        int rowPos = position[0];
        int colPos = position[1];
        int jetFighterArmor = 300;


        String command = kbInput.nextLine();

        while (enemyCount != 0 && jetFighterArmor != 0){

            switch (command){

                case "up":

                if ("E".equalsIgnoreCase(matrix[rowPos -1][colPos])){

                    matrix[rowPos -1][colPos] = "J";
                    matrix[rowPos][colPos] = "-";
                    rowPos = rowPos - 1;


                    if (enemyCount > 1){
                        enemyCount--;
                        jetFighterArmor -= 100;
                    }else if (enemyCount == 1){
                        enemyCount--;
                    }
                    if (enemyCount == 0){
                        System.out.println("Mission accomplished, you neutralized the aerial threat!");
                        printMatrix(matrix);
                        return;
                    }
                    if (jetFighterArmor == 0){

                        System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",rowPos,colPos);
                        printMatrix(matrix);
                        return;
                    }

                } else if ("R".equalsIgnoreCase(matrix[rowPos - 1][colPos])) {
                    if (jetFighterArmor < 300){
                        jetFighterArmor = 300;
                    }
                    matrix[rowPos -1][colPos] = "J";
                    matrix[rowPos][colPos] = "-";
                    rowPos = rowPos - 1;
                } else if ("-".equalsIgnoreCase(matrix[rowPos - 1][colPos])) {
                    matrix[rowPos -1][colPos] = "J";
                    matrix[rowPos][colPos] = "-";
                    rowPos = rowPos - 1;
                }

                    break;
                case "down":
                    if ("E".equalsIgnoreCase(matrix[rowPos + 1][colPos])){

                        matrix[rowPos + 1][colPos] = "J";
                        matrix[rowPos][colPos] = "-";
                        rowPos = rowPos + 1;


                        if (enemyCount > 1){
                            enemyCount--;
                            jetFighterArmor -= 100;
                        }else if (enemyCount == 1){
                            enemyCount--;
                        }
                        if (enemyCount == 0){
                            System.out.println("Mission accomplished, you neutralized the aerial threat!");
                            printMatrix(matrix);
                            return;
                        }
                        if (jetFighterArmor == 0){

                            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",rowPos,colPos);
                            printMatrix(matrix);
                            return;
                        }

                    } else if ("R".equalsIgnoreCase(matrix[rowPos + 1][colPos])) {
                        if (jetFighterArmor < 300){
                            jetFighterArmor = 300;
                        }
                        matrix[rowPos + 1][colPos] = "J";
                        matrix[rowPos][colPos] = "-";
                        rowPos = rowPos + 1;
                    } else if ("-".equalsIgnoreCase(matrix[rowPos + 1][colPos])) {
                        matrix[rowPos + 1][colPos] = "J";
                        matrix[rowPos][colPos] = "-";
                        rowPos = rowPos + 1;
                    }

                    break;
                case "left":

                    if ("E".equalsIgnoreCase(matrix[rowPos][colPos - 1])){

                        matrix[rowPos][colPos - 1] = "J";
                        matrix[rowPos][colPos] = "-";
                        colPos = colPos - 1;


                        if (enemyCount > 1){
                            enemyCount--;
                            jetFighterArmor -= 100;
                        }else if (enemyCount == 1){
                            enemyCount--;
                        }
                        if (enemyCount == 0){
                            System.out.println("Mission accomplished, you neutralized the aerial threat!");
                            printMatrix(matrix);
                            return;
                        }

                        if (jetFighterArmor == 0){

                            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",rowPos,colPos);
                            printMatrix(matrix);
                            return;
                        }

                    } else if ("R".equalsIgnoreCase(matrix[rowPos][colPos -1])) {
                        if (jetFighterArmor < 300){
                            jetFighterArmor = 300;
                        }
                        matrix[rowPos][colPos - 1] = "J";
                        matrix[rowPos][colPos] = "-";
                        colPos = colPos - 1;
                    } else if ("-".equalsIgnoreCase(matrix[rowPos][colPos - 1])) {
                        matrix[rowPos][colPos - 1] = "J";
                        matrix[rowPos][colPos] = "-";
                        colPos = colPos - 1;
                    }
                    break;
                case "right":
                    if ("E".equalsIgnoreCase(matrix[rowPos][colPos + 1])){

                        matrix[rowPos][colPos + 1] = "J";
                        matrix[rowPos][colPos] = "-";
                        colPos = colPos + 1;


                        if (enemyCount > 1){
                            enemyCount--;
                            jetFighterArmor -= 100;
                        }else if (enemyCount == 1){
                            enemyCount--;
                        }
                        if (enemyCount == 0){
                            System.out.println("Mission accomplished, you neutralized the aerial threat!");
                            printMatrix(matrix);
                            return;
                        }

                        if (jetFighterArmor == 0){

                            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",rowPos,colPos);
                            printMatrix(matrix);
                            return;
                        }

                    } else if ("R".equalsIgnoreCase(matrix[rowPos][colPos + 1])) {
                        if (jetFighterArmor < 300){
                            jetFighterArmor = 300;
                        }
                        matrix[rowPos][colPos + 1] = "J";
                        matrix[rowPos][colPos] = "-";
                        colPos = colPos + 1;
                    } else if ("-".equalsIgnoreCase(matrix[rowPos][colPos + 1])) {
                        matrix[rowPos][colPos + 1] = "J";
                        matrix[rowPos][colPos] = "-";
                        colPos = colPos + 1;
                    }
                    break;
            }

            command = kbInput.nextLine();


        }



    }

    private static void fillTheMatrix(int row, String[][] matrix, Scanner kbInput) {
        for (int i = 0; i < row; i++) {

            matrix[i] = Arrays.stream(kbInput.nextLine().split("")).toArray(String[]::new);

        }
    }

    private static int[] findPosition(String[][] matrix) {
        int rowPos = 0;
        int colPos = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equalsIgnoreCase("J")) {

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
    private static int findEnemiesCount(String[][] matrix) {
        int enemiesCount = 0;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equalsIgnoreCase("E")) {
                    enemiesCount++;
                }
            }
        }

        return enemiesCount;
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
