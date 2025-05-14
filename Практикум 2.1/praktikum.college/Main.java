package praktikum.college;

import java.util.Scanner;
import static praktikum.college.diaryApplication.*;
import static praktikum.college.util.FilesystemUtilities.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] diary = new String[50][3];
    public static int diaryPointer = 0;

    public static void main(String[] args) {
        boolean programRunning = true;
        for (int i = 0; i <= 49; i++) {
            diary[i][0] = Integer.toString(i + 1);
            diary[i][1] = "";
            diary[i][2] = "";
        }
        while (programRunning) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Записати у щоденник");
            System.out.println("2. Прочитати з щоденника");
            System.out.println("3. Видалити запис");
            System.out.println("4. Прочитати та завантажити існуючий щоденник");
            System.out.println("5. Зберегти щоденник у файл");
            System.out.println("6. Вимкнути програму");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    writeToDiary(diaryPointer, scanner, diary);
                    break;
                case "2":
                    readFromDiary(diary);
                    break;
                case "3":
                    deleteFromDiary(scanner, diary);
                    break;
                case "4":
                    readAndLoadExistingDiary(diary);
                    break;
                case "5":
                    System.out.println("Зберегти щоденник? Так/Ні \n" +
                            "Увага: Це перезапише попередній збереженний щоденник");
                    if (scanner.nextLine().equals("Так")) {
                        saveDiary(diary);
                    }
                    break;
                case "6":
                    System.out.println("Програма вимикається");
                    scanner.close();
                    programRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}