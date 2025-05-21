package praktichna16.file;

import java.io.*;

public class FilesystemUtilities {
    public static void saveSettings(boolean startSymbol, int size, boolean playingAgainstRandom) {
        System.out.println("Налаштування буде збережено за шляхом: " + System.getProperty("user.dir"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("settings.txt"))) {
            String s = "";
            s += startSymbol + "\n";
            s += size + "\n";
            s += playingAgainstRandom + "\n";
            writer.write(s);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }

    public static void loadSettings(boolean startSymbol, int size, boolean playingAgainstRandom) {
        try (BufferedReader reader = new BufferedReader(new FileReader("settings.txt"))) {
            startSymbol = Boolean.parseBoolean(reader.readLine());
            size = Integer.parseInt(reader.readLine());
            playingAgainstRandom = Boolean.parseBoolean(reader.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні файлу");
        }
    }

    public static void saveStats(int size, boolean playingAgainstRandom, boolean startSymbol, boolean tie) {
        System.out.println("Статистику по цій грі буде збережено за шляхом: " + System.getProperty("user.dir"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lastPlayedGame.txt"))) {
            String s = "Розмір поля: " + size + "\n";
            if (playingAgainstRandom) {
                s += "Гра проти компєютера: ввімкнена \n";
            } else {
                s += "Гра проти компєютера: вимкнена \n";
            }
            if (startSymbol) {
                s += "Символ останнього хода: Х\n";
            } else {
                s += "Символ останнього хода: 0\n";
            }
            if (tie) {
                s += "Гра закінчилась нічиєю";
            } else {
                s += "Гра закінчилась перемогою останнього зіграного символа";
            }
            writer.write(s);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }
}