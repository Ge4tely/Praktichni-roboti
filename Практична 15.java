import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.lang.Math;
import java.io.*;
import java.time.LocalDateTime;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int input;
    public static int x;
    public static int y;
    public static boolean startSymbol;
    public static int size;
    public static boolean playingAgainstRandom;

    public static void saveSettings() {
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

    public static void loadSettings(){
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
                s += "Гра закінчилась перемогою останнього зіграного символа\n";
            }
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
            s += "Дата та час гри: " + now.format(format);
            writer.write(s);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }

    public static void drawBoard(int size, Character[][] field) {
        for (int i = 1; i < size + 2; i++) {
            for (int j = 1; j < size + 2; j++) {
                System.out.print(field[i - 1][j - 1] + " | ");
            }
            System.out.println();
            for (int p = 0; p < size + 1; p++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }

    public static boolean win(int size, boolean playingAgainstRandom, Character[][] field, boolean startSymbol, boolean over) {
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {                                                 //Діагональна перемога 1
                if (field[j][i] == 'X' && field[j + 1][i + 1] == 'X' && field[j + 2][i + 2] == 'X') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога Х");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    return over;
                }
                if (field[j][i] == '0' && field[j + 1][i + 1] == '0' && field[j + 2][i + 2] == '0') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога 0");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    startSymbol = false;
                    return over;
                }
            }
        }
        for (int i = size; i > 1; i--) {
            for (int j = size; j > 1; j--) {                                                      //Діагональна перемога 2
                if (field[j][i - 2] == 'X' && field[j - 1][i - 1] == 'X' && field[j - 2][i] == 'X') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога Х");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    return over;
                }
                if (field[j][i - 2] == '0' && field[j - 1][i - 1] == '0' && field[j - 2][i] == '0') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога 0");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    startSymbol = false;
                    return over;
                }
            }
        }
        for (int i = 1; i < size + 1; i++) {                                                       //Вертикальна перемога
            for (int j = 1; j < size + 1; j++) {
                if (field[i][j] == 'X' && field[i - 1][j] == 'X' && field[i - 2][j] == 'X') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога Х");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    return over;
                }
                if (field[i][j] == '0' && field[i - 1][j] == '0' && field[i - 2][j] == '0') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога 0");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    startSymbol = false;
                    return over;
                }
            }
        }
        for (int i = 1; i < size + 1; i++) {                                                       //Горизонтальна перемога
            for (int j = 1; j < size + 1; j++) {
                if (field[i][j] == 'X' && field[i][j - 1] == 'X' && field[i][j - 2] == 'X') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога Х");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    return over;
                }
                if (field[i][j] == '0' && field[i][j - 1] == '0' && field[i][j - 2] == '0') {
                    if (!startSymbol || playingAgainstRandom) {
                        drawBoard(size, field);
                    }
                    over = true;
                    System.out.println("Перемога 0");
                    if (!playingAgainstRandom) {
                        System.out.println("Введіть будь яке число що б продовжити");
                    }
                    startSymbol = false;
                    return over;
                }
            }
        }
        return false;
    }

    public static void isValid(int size, Character[][] field) {
        while (!scanner.hasNextInt()) {
            System.out.println("Літери не підтримуються. Спробуйте ще раз");
            System.out.println("Введіть координату для вашого ходу. Введіть 0 для повернення до меню");
            drawBoard(size, field);
            scanner.next();
        }
        input = scanner.nextInt();
        while (input < 1) {
            if (input == 0) {
                break;
            }
            System.out.println("Замале значення. Введіть координату для вашого ходу. Введіть 0 для повернення до меню");
            input = scanner.nextInt();
        }
        while (input > size) {
            System.out.println("Завелике значення. Введіть координату для вашого ходу. Введіть 0 для повернення до меню");
            input = scanner.nextInt();
        }
    }

    public static void main(String[] args) {
        String input_str;
        startSymbol = true;
        size = 3;
        int count = 0;
        boolean over = false;
        playingAgainstRandom = false;
        boolean tie = false;
        String string1 = ("""
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                I                    Меню                     I
                | 1) Грати                                    |
                I 2) Налаштування                             I
                | 3) Вихід з гри                              |
                I                                             I
                |                                             |
                I                                             I
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """);
        String string2 = ("""
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                I                    НАЛАШТУВАННЯ             I
                | 1)Початковий символ 1) Х 2) 0               |
                I 2) Розмір поля                              I
                | 3) Гра проти комп'ютера                     |
                I 4) Зберегти налаштування                    I
                | 5) Імпортувати налаштування з файлу         |
                I 6) Вихід до меню                            I
                -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """);
        boolean exit = true;
        boolean done;
        System.out.println(string1);
        while (exit) {
            tie = false;
            input_str = scanner.nextLine();
            switch (input_str) {
                case "1": {
                    Character field[][] = new Character[size + 1][size + 1];
                    for (int i = 0; i < size + 1; i++) {
                        for (int j = 0; j < size + 1; j++) {
                            field[i][j] = '-';
                        }
                        field[0][i] = (char) (i + '0');
                        field[i][0] = (char) (i + '0');
                    }
                    if (startSymbol || playingAgainstRandom) {
                        System.out.println("Обраний початковий символ = Х");
                    } else {
                        System.out.println("Обраний початковий символ = 0");
                    }
                    if (playingAgainstRandom) {
                        System.out.println("Гра проти комп'ютера активована");
                        startSymbol = true;
                    } else {
                        System.out.println("Гра проти комп'ютера НЕ активована");
                    }

                    System.out.println("Введіть стовпчик для вашого ходу. Введіть 0 для повернення до меню");
                    drawBoard(size, field);
                    isValid(size, field);
                    x = input;
                    if (over) {
                        over = false;
                    }
                    switch (input) {
                        case 0: {
                            break;
                        }
                        default:
                            System.out.println("Введіть рядок для вашого ходу. Введіть 0 для повернення до меню");
                            while (!over) {
                                if (playingAgainstRandom && !startSymbol) {
                                    do {
                                        y = (int) (10 * Math.random());
                                    } while (y > size || y < 1);
                                    while (field[y][x] == 'X' || field[y][x] == '0') {
                                        do {
                                            y = (int) (10 * Math.random());
                                            x = (int) (10 * Math.random());
                                        } while (y > size || x > size || x < 1 || y < 1);
                                    }
                                    field[y][x] = '0';
                                    drawBoard(size, field);
                                } else {
                                    if (count > 0) {
                                        System.out.println("Введіть рядок для вашого ходу. Введіть 0 для повернення до меню");
                                    }
                                    isValid(size, field);
                                    y = input;
                                    if (field[y][x] == 'X' || field[y][x] == '0') {
                                        System.out.println("Неправильний ход. Клітинка зайнята");
                                        continue;
                                    }
                                }

                                if (startSymbol) {
                                    field[y][x] = 'X';
                                } else {
                                    field[y][x] = '0';
                                }
                                if (!playingAgainstRandom) {
                                    drawBoard(size, field);
                                }
                                count++;

                                if (count >= 3) {
                                    if (win(size, playingAgainstRandom, field, startSymbol, over)) {
                                        count = 0;
                                        break;
                                    }
                                }

                                if (count == size * size) {
                                    if (!startSymbol || playingAgainstRandom) {
                                        drawBoard(size, field);
                                    }
                                    System.out.println("Нічия");
                                    count = 0;
                                    tie = true;
                                    break;
                                }
                                startSymbol = !startSymbol;
                                if (playingAgainstRandom && !startSymbol) {
                                    do {
                                        x = (int) (10 * Math.random());
                                    } while (x > size || x < 1);
                                } else {
                                    System.out.println("Введіть стовпчик для вашого ходу. Введіть 0 що б вийти до меню");
                                    isValid(size, field);
                                    if (input == 0) {
                                        count = 0;
                                        over = true;
                                    }
                                }
                                isValid(size, field);
                                x = input;
                            }

                    }
                    saveStats(size, playingAgainstRandom, startSymbol, tie);
                    break;
                }
                case "2": {
                    done = true;
                    System.out.println(string2);
                    while (done) {
                        input_str = scanner.nextLine();
                        switch (input_str) {
                            case "1": {
                                System.out.println("Введіть 1 знову що б вибрати Х як початковий символ, 2 що б вибрати 0");
                                input_str = scanner.nextLine();
                                if (input_str.equals("1")) {
                                    System.out.println("Х - початковий символ");
                                    startSymbol = true;
                                    System.out.println(string2);
                                    break;
                                } else if (input_str.equals("2")) {
                                    System.out.println("0 - початковий символ");
                                    startSymbol = false;
                                    System.out.println(string2);
                                    break;
                                } else {
                                    System.out.println("Неправильний ввод. Повертаємо до налаштувань");
                                    System.out.println(string2);
                                    break;
                                }
                            }
                            case "2": {
                                System.out.println("""
                                        Введіть нове значення розміру поля. Поле не може бути менше за 3х3. Поле не може бути більше за 9х9""");
                                if (scanner.hasNextInt()) {
                                    input = scanner.nextInt();
                                    if (input >= 3) {
                                        size = input;
                                        if (input > 9) {
                                            System.out.println("Задано завеликий розмір. Встановлено максимальний. Розмір - 9х9");
                                            size = 9;
                                        } else {
                                            System.out.println("""
                                                    Розмір встановлено""");
                                        }
                                    } else {
                                        System.out.println("""
                                                Замале значення... Повертаємо до налаштувань""");
                                    }
                                    break;
                                } else {
                                    System.out.println("""
                                            Неправильне значення... Повертаємо до налаштувань""");
                                    break;
                                }
                            }
                            case "3": {
                                System.out.println("Введіть 1 що б активувати гру проти комп'ютера. Введіть 2 що дизактивувати гру проти комп'ютера. Введіть будь-що інше що б повернутись до меню");
                                input_str = scanner.nextLine();
                                switch (input_str) {
                                    case "1":
                                        System.out.println("Гра проти комп'ютера активована. Початковий символ - Х");
                                        startSymbol = true;
                                        playingAgainstRandom = true;
                                        System.out.println(string2);
                                        break;
                                    case "2":
                                        System.out.println("Гра проти комп'ютера дизактивована");
                                        System.out.println(string2);
                                        playingAgainstRandom = false;
                                        break;
                                    default:
                                        System.out.println("Неправильний символ. Повертаємо до налаштувань");
                                        System.out.println(string2);
                                        break;
                                }
                                break;
                            }
                            case "4":{
                                saveSettings();
                                System.out.println("Налаштування збережено");
                                break;
                            }
                            case "5": {
                                loadSettings();
                                System.out.println("Налаштування імпортовано");
                                break;
                            }
                            case "6": {
                                done = false;
                                System.out.println(string1);
                                break;
                            }
                            default:
                                System.out.println(string2);
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println("""
                            -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                            I                     МЕНЮ                    I
                            |Програма закривається...                     |
                            I                                             I
                            |                                             |
                            I                                             I
                            |                                             |
                            -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=""");
                    exit = false;
                    break;
                }
                default:
                    System.out.println(string1);
            }
        }
    }
}
