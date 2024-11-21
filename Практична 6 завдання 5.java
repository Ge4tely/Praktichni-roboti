import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Введіть кількість розмір масиву: ");
        int size = scanner.nextInt();

        int[] a = new int[size];
        for (int i=0; i<size; i++) {
            a[i] = rand.nextInt(100);
        }
        System.out.println("Згенерований масив: ");
        System.out.println(Arrays.toString(a));
        String b = "";

        System.out.println("Введіть False якщо хочете перевірити чи спадає масив та True якщо хочете перевірити чи зростає масив: ");
        boolean ascOrDes = scanner.nextBoolean();
        if (ascOrDes) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < a[i + 1]) {
                    b = "Зростає";
                } else {
                    b = "Не зростає";
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    b = "Спадає";
                } else {
                    b = "Не спадає";
                    break;
                }
            }
        }
        System.out.println(b);
    }
}
