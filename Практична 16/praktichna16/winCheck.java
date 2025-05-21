package praktichna16;

public class winCheck {

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
}