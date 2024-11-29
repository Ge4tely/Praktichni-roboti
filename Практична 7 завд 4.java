import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Введіть розмір квадратної матриці (N x N): ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Згенерована матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(201)-100;
            }
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.print("Введіть номер рядка (від 1 до " + n + ") для виключення: ");
        int rowToRemove = sc.nextInt() - 1;
        System.out.print("Введіть номер стовпця (від 1 до " + n + ") для виключення: ");
        int colToRemove = sc.nextInt() - 1;

        int[][] minor = new int[n - 1][n - 1];
        int subRow = 0;
        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;
            int subCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;
                minor[subRow][subCol] = matrix[i][j];
                subCol++;
            }
            subRow++;
        }
        System.out.println("Мінор:");
        for (int i = 0; i < minor.length; i++) {
            System.out.println(Arrays.toString(minor[i]));
        }
    }
}
