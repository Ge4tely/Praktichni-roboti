import java.util.Scanner;

public class Praktichna7 {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean twoWords() {
        System.out.println("Введіть як мінімум 2 слова(як мінімум 3 символи на слово):");
        String stringWithWords = scanner.nextLine().trim();
        return stringWithWords.indexOf(' ') > 2 && stringWithWords.length() - stringWithWords.lastIndexOf(' ') > 3;
    }

    public static String reverseString(String stringForReversal) {
        String stringReversed = "";
        for (int i = stringForReversal.length() - 1; i >= 0; i--) {
            stringReversed += (stringForReversal.charAt(i));
        }
        return stringReversed;
    }

    public static String reverseWords(String stringForReversal) {
        String stringReversed = "";
        String[] arr = stringForReversal.split(" ");
        for (String s : arr) {
            stringReversed += reverseString(s) + " ";
        }
        return stringReversed;
    }

    public static void main(String[] args) {
        boolean isValid;
        do {
            isValid = twoWords();
        } while (!isValid);
        System.out.println("Слова введено правильно");

        System.out.println("Введіть строку для відзеркалення:");
        String stringForReversal = scanner.nextLine();
        System.out.println("Введіть 1 для відзеркалення всієї строки. Введіть будь яке інше число для відзеркалення лише слів");
        int choice;
        choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Відзеркаленна строка:");
            System.out.println(reverseString(stringForReversal));
        } else {
            System.out.println("Відзеркаленна строка, по словам:");
            System.out.println(reverseWords(stringForReversal));
        }
    }
}