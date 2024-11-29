import java.util.Scanner;
import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Матриця для заповнення:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.print("Введіть 25 чисел для матриці, кожне окремо: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Матриця заповнена:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int det = 0;
        for (int col = 0; col < 5; col++) {
            int sign;
            if (col % 2 == 0) {
                sign = 1;
            } else {
                sign = -1;
            }
            int[][] subMatrix = new int[4][4];
            for (int i = 1; i < 5; i++) {
                int subCol = 0;
                for (int j = 0; j < 5; j++) {
                    if (j == col) continue;
                    subMatrix[i - 1][subCol] = matrix[i][j];
                    subCol++;
                }
            }
            int subDet = subMatrix[0][0] *
                    (subMatrix[1][1] * (subMatrix[2][2] * subMatrix[3][3] - subMatrix[2][3] * subMatrix[3][2])
                    - subMatrix[1][2] * (subMatrix[2][1] * subMatrix[3][3] - subMatrix[2][3] * subMatrix[3][1])
                    + subMatrix[1][3] * (subMatrix[2][1] * subMatrix[3][2] - subMatrix[2][2] * subMatrix[3][1])) //Визначник першого мінору

                    - subMatrix[0][1] *
                    (subMatrix[1][0] * (subMatrix[2][2] * subMatrix[3][3] - subMatrix[2][3] * subMatrix[3][2])
                    - subMatrix[1][2] * (subMatrix[2][0] * subMatrix[3][3] - subMatrix[2][3] * subMatrix[3][0])
                    + subMatrix[1][3] * (subMatrix[2][0] * subMatrix[3][2] - subMatrix[2][2] * subMatrix[3][0])) //Визначник другого мінору

                    + subMatrix[0][2] *
                    (subMatrix[1][0] * (subMatrix[2][1] * subMatrix[3][3] - subMatrix[2][3] * subMatrix[3][1])
                    - subMatrix[1][1] * (subMatrix[2][0] * subMatrix[3][3] - subMatrix[2][3] * subMatrix[3][0])
                    + subMatrix[1][3] * (subMatrix[2][0] * subMatrix[3][1] - subMatrix[2][1] * subMatrix[3][0])) //Визначник третього мінору

                    - subMatrix[0][3] *
                    (subMatrix[1][0] * (subMatrix[2][1] * subMatrix[3][2] - subMatrix[2][2] * subMatrix[3][1])
                    - subMatrix[1][1] * (subMatrix[2][0] * subMatrix[3][2] - subMatrix[2][2] * subMatrix[3][0])
                    + subMatrix[1][2] * (subMatrix[2][0] * subMatrix[3][1] - subMatrix[2][1] * subMatrix[3][0])); //Визначник четвертого мінору

            det += sign * matrix[0][col] * subDet;
        }
        System.out.println("Визначник матриці: " + det);
    }
}
