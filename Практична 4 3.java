import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть початок діапазону: ");
        int beginning = scanner.nextInt();
        System.out.print("Введіть кінець діапазону: ");
        int end = scanner.nextInt();
        System.out.print("Введіть просте число (від 1 до 9): ");
        int a = scanner.nextInt();
        for (int i = beginning; i <= end; i++) {
            if (i % a == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
