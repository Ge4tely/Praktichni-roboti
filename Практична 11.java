import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static FileWriter fw = null;
    public static FileReader fr = null;
    public static boolean programRunning = true;
    public static void txtWrite() {
        System.out.println("Файл буде створено / буде записано у файл за шляхом " + System.getProperty("user.dir"));
        System.out.println("Введіть кількість рядків, що будете вводити:");
        int n;
        while(true) {
            try {
                n = scanner.nextInt();
                scanner.nextLine();
                if (n<1){
                    System.out.println("Будь ласка, вводіть тільки натуральні числа!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, вводіть тільки натуральні числа!");
                scanner.next();
            }
        }
        try {
            fw = new FileWriter("file.txt", true);
            System.out.println("Введіть рядок(рядки) для запису в файл:");
            for(int i = 0; i<n; i++){
                System.out.print((i+1) + ". ");
                String nextEntry = scanner.nextLine();
                fw.write(nextEntry + "\n");
            }
            System.out.println("Рядок(рядки) успішно записано в файл!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println("Виникла помилка при закритті файлу");
            }
        }
    }
    public static void txtRead() {
        System.out.println("Буде зчитано з файлу за шляхом " + System.getProperty("user.dir"));
        try {
            fr = new FileReader("file.txt");
            String s = "";
            System.out.println("Текст з файлу: \n");
            while (fr.ready()) {
                s += (char) fr.read();
            }
            System.out.println(s);
            System.out.println("Успішно зчитано з файлу! Перекидуємо до меню...");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Виникла помилка при закритті файлу");
            }
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
            while(true) {
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