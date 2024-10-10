import java.text.MessageFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть ціле число");
        int a = sc.nextInt();
        sc.nextLine();

        System.out.println("Введіть число з плаваючою крапкою");
        Double b = sc.nextDouble();
        sc.nextLine();

        System.out.println("Введіть строку");
        String c = sc.nextLine();

        System.out.println("Введіть булеве значення");
        Boolean d = sc.nextBoolean();


        //Виведення:
        System.out.println("Ціле число, виведене способом 1: " + a);
        String template1 = "Ціле число, виведене способом 2: {0}";
        String message1 = MessageFormat.format(template1, a);
        System.out.println(message1);
        String format1 = "Ціле число у десятковій системі: %d, у шістнадцятковій: %x і у вісімковій: %o, виведені способом 3\n";
        System.out.printf(format1, a, a, a);

        System.out.println("Число з плаваючою крапкою, виведене способом 1: " + b);
        String template2 = "Число з плаваючою крапкою, виведене способом 2: {0}";
        String message2 = MessageFormat.format(template2, b);
        System.out.println(message2);
        String format2 = "Число з плаваючою крапкою, виведене способом 3: %f\n";
        System.out.printf(format2, b);

        System.out.println("Строка, виведена способом 1: " + c);
        String template3 = "Строка, виведена способом 2: {0}";
        String message3 = MessageFormat.format(template3, c);
        System.out.println(message3);
        String format3 = "Строка, виведена способом 3: %s\n";
        System.out.printf(format3, c);

        System.out.println("Логічне значення, виведене способом 1: " + d);
        String template4 = "Логічне значення, виведене способом 2: {0}";
        String message4 = MessageFormat.format(template4, d);
        System.out.println(message4);
        String format4 = "Логічне значення, виведене способом 3: %b\n";
        System.out.printf(format4, d);
    }
}
