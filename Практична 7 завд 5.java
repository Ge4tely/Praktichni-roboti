import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class task5 {
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
        System.out.println("Транспонована матриця:");
        int[][] invertedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                invertedMatrix[i][j] = matrix[j][i];
            }
            System.out.println(Arrays.toString(invertedMatrix[i]));
        }
    }
}
