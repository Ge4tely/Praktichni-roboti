import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean programRunning = true;

    public static void txtWrite() {
        System.out.println("Файл буде створено / буде записано у файл за шляхом " + System.getProperty("user.dir"));
        System.out.println("Введіть кількість рядків, що будете вводити:");
        int n;
        while (true) {
            try {
                n = scanner.nextInt();
                scanner.nextLine();
                if (n < 1) {
                    System.out.println("Будь ласка, вводіть тільки натуральні числа!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, вводіть тільки натуральні числа!");
                scanner.next();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));) {
            System.out.println("Введіть рядок(рядки) для запису в файл:");
            int j = linesCount()+1;
            for (int i = 0; i < n; i++) {
                System.out.print((j + ". "));
                String nextEntry = scanner.nextLine();
                writer.write(nextEntry + "\n");
                j++;
            }
            System.out.println("Рядок(рядки) успішно записано в файл!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }

    public static int linesCount(){
        int i=0;
        try (BufferedReader countLine = new BufferedReader(new FileReader("file.txt"))) {
            while(countLine.readLine() != null){
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при рахуванні рядків з файлу");
        }
        return i;
    }

    public static void txtRead() {
        System.out.println("Буде зчитано з файлу за шляхом " + System.getProperty("user.dir"));
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            int j = linesCount();

            System.out.println("Введіть діапазон для виводу рядків (всього рядків у файлі: " + j + ") . Введіть 0 що б вивести весь файл.");
            int input = 0;
            do{
                input = scanner.nextInt();
            }while(input>j);

            if(input == 0){
                String s = "";
                System.out.println("Текст з файлу: \n");
                int i = 0;
                while (reader.ready()) {
                    i++;
                    s = reader.readLine();
                    System.out.println(i + ". " + s);
                }
            }
            else{
                int lower = input;
                System.out.println("Нижня границя діапазона введена! Введіть верхню:");
                do{
                    input = scanner.nextInt();
                }while(input>j);
                int upper = input;
                System.out.println("Верхня границя діапазона введена!");
                if (upper < lower){
                    int temp = lower;
                    lower = upper;
                    upper = temp;
                    System.out.println("Верхня границя була менша за нижню. Їх було змінено місцями");
                }
                System.out.println("Текст з файлу з " + lower + " по " + upper + "рядки");
                String s = "";
                int i = 0;
                while (reader.ready()) {
                    i++;
                    if(i >= lower && i <= upper){
                        s = reader.readLine();
                        System.out.println(i + ". " + s);
                    }
                    if(i>upper){
                        break;
                    }
                }
            }

            System.out.println("Успішно зчитано з файлу! Перекидуємо до меню...");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
        }
    }

    public static void txtLeave() {
        programRunning = false;
        scanner.close();
    }

    public static void menuOutput() {
        System.out.println("Оберіть дію");
        System.out.println("1. Записати у файл");
        System.out.println("2. Прочитати з файлу");
        System.out.println("3. Вийти з програми");
    }

    public static void main(String[] args) {
        while (programRunning) {
            menuOutput();
            int input;
            while (true) {
                try {
                    input = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Будь ласка, вводіть тільки цифри!");
                    menuOutput();
                    scanner.next();
                }
            }
            switch (input) {
                case 1:
                    txtWrite();
                    break;
                case 2:
                    txtRead();
                    break;
                case 3:
                    txtLeave();
                    break;
            }
        }
    }
}