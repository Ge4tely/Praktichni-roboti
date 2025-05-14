package praktikum.college;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class diaryApplication {
    public static void writeToDiary(int diaryPointer, Scanner scanner, String[][] diary) {
        if (diaryPointer >= 49) {
            System.out.println("У щоденнику закінчилось місце");
        } else {
            System.out.println("Положення показчика щоденника: " + (diaryPointer + 1));
            System.out.println("Введіть дату у форматі день.місяць.рік, все числами, дд.мм.рррр");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String dateUnparsed = scanner.nextLine();
            LocalDate timeEntry = LocalDate.parse(dateUnparsed, formatter);
            System.out.println("Введіть запис для цієї дати");
            String textEntry = scanner.nextLine();
            diary[diaryPointer][1] = " "+timeEntry.toString()+" ";
            diary[diaryPointer][2] = textEntry;
            System.out.println("Запис успішно додано!");
            diaryPointer++;
        }
    }

    public static void readFromDiary(String[][] diary) {
        for (int i = 0; i < 50; i++) {
            System.out.println(Arrays.toString(diary[i]));
        }
    }

    public static void deleteFromDiary(Scanner scanner, String[][] diary) {
        System.out.println("Введіть номер запису що хочете видалити");
        int entryToBeDeleted = 0;
        do {
            System.out.println("Номер повинен бути між 1 та 50:");
            entryToBeDeleted = scanner.nextInt();
        } while (entryToBeDeleted > 50 || entryToBeDeleted < 0);
        diary[entryToBeDeleted - 1][1] = null;
        diary[entryToBeDeleted - 1][2] = null;
        System.out.println("Запис і дату успішно видалено!");
        scanner.nextLine();
    }
}
