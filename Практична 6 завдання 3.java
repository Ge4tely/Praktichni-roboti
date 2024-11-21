import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Введіть кількість розмір масиву: ");
        int size = scanner.nextInt();

            int[] numbers = new int[size];
            for (int i=0; i<size; i++) {
                numbers[i] = rand.nextInt(100);
            }
            System.out.println("Згенерований масив: ");
            System.out.println(Arrays.toString(numbers));

            System.out.println("Введіть число з масиву для заміни: ");
            int entered_number = scanner.nextInt();

            System.out.println("Введіть число на яке хочете його замінити: ");
            int replaced_number = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                if (entered_number == numbers[i]) {
                    numbers[i] = replaced_number;
                    break;
                }
            }
            System.out.println("Результат заміни: ");
            System.out.println(Arrays.toString(numbers));
    }
}
