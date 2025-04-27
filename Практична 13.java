import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] diary = new String[50][3];
    public static int diaryPointer = 0;

    public static void writeToDiary(){
        if (diaryPointer >= 49) {
            System.out.println("У щоденнику закінчилось місце");
        }
        else{
            System.out.println("Положення показчика щоденника: " + diaryPointer+1);
            System.out.println("Введіть дату у форматі день.місяць.рік, все числами, дд.мм.рррр");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String dateUnparsed = scanner.nextLine();
            LocalDate timeEntry = LocalDate.parse(dateUnparsed, formatter);
            System.out.println("Введіть запис для цієї дати");
            String textEntry = scanner.nextLine();
            diary[diaryPointer][1] = timeEntry.toString();
            diary[diaryPointer][2] = textEntry;
            System.out.println("Запис успішно додано!");
            diaryPointer++;
        }
    }

    public static void readFromDiary(){
        for(int i = 0; i<50; i++){
            System.out.println(Arrays.toString(diary[i]));
        }
    }

    public static void deleteFromDiary(){
        System.out.println("Введіть номер запису що хочете видалити");
        int entryToBeDeleted = 0;
        do{
            System.out.println("Номер повинен бути між 1 та 50:");
            entryToBeDeleted = scanner.nextInt();
        }while(entryToBeDeleted > 50 || entryToBeDeleted < 0);
        diary[entryToBeDeleted-1][1] = null;
        diary[entryToBeDeleted-1][2] = null;
        System.out.println("Запис і дату успішно видалено!");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        boolean programRunning = true;
        for (int i = 0; i<=49; i++){
            diary[i][0] = Integer.toString(i+1);
        }
        while(programRunning) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Записати у щоденник");
            System.out.println("2. Прочитати з щоденника");
            System.out.println("3. Видалити запис");
            System.out.println("4. Вимкнути програму");
            String input = scanner.nextLine();
            switch(input){
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
                    System.out.println("Програма вимикається");
                    scanner.close();
                    programRunning = false;
                    break;
            }
        }
    }
}