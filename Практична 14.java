import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] diary = new String[50][3];
    public static int diaryPointer = 0;

    public static void writeToDiary() {
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

    public static void readFromDiary() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Arrays.toString(diary[i]));
        }
    }

    public static void saveDiary() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))){
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(diary[i][j]);
                }
                writer.write("\n");
            }
            System.out.println("Щоденник успішно записано в файл!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        } catch (NullPointerException e){
        }
        System.out.println("Щоденник успішно збережено");
    }

    public static void readAndLoadExistingDiary() {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String s = "";
            System.out.println("Записи з щоденника: \n");
            int i = 0;
            int j = 1;
            while (reader.ready()) {
                s = reader.readLine();
                System.out.println(s);
                diary[i][0] = Integer.toString(j);
                if (i > 9) {
                    diary[i][1] = s.substring(3, 13);
                    diary[i][2] = s.substring(14);
                } else {
                    if(!s.isEmpty()){
                        diary[i][1] = s.substring(2, 12);
                        diary[i][2] = s.substring(13);
                    }
                    else{
                        diary[i][1] = "";
                        diary[i][2] = "";
                    }
                }
                i++;
                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
        } catch (StringIndexOutOfBoundsException e){
        }
    }

    public static void deleteFromDiary() {
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
                    writeToDiary();
                    break;
                case "2":
                    readFromDiary();
                    break;
                case "3":
                    deleteFromDiary();
                    break;
                case "4":
                    readAndLoadExistingDiary();
                    break;
                case "5":
                    System.out.println("Зберегти щоденник? Так/Ні \n" +
                            "Увага: Це перезапише попередній збереженний щоденник");
                    if (scanner.nextLine().equals("Так")) {
                        saveDiary();
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