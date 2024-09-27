import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Byte:");
        System.out.println("Розмір: " + Byte.BYTES + " Байт");
        System.out.println("Мінімальне значення: " + Byte.MIN_VALUE);
        System.out.println("Максимальне значення: " + Byte.MAX_VALUE);

        System.out.println("Short:");
        System.out.println("Розмір: " + Short.BYTES + " Байт");
        System.out.println("Мінімальне значення: " + Short.MIN_VALUE);
        System.out.println("Максимальне значення: " + Short.MAX_VALUE);

        System.out.println("Int:");
        System.out.println("Розмір: " + Integer.BYTES + " Байт");
        System.out.println("Мінімальне значення: " + Integer.MIN_VALUE);
        System.out.println("Максимальне значення: " + Integer.MAX_VALUE);

        System.out.println("Long:");
        System.out.println("Розмір: " + Long.BYTES + " Байт");
        System.out.println("Мінімальне значення: " + Long.MIN_VALUE);
        System.out.println("Максимальне значення: " + Long.MAX_VALUE);

        System.out.println("Float:");
        System.out.println("Розмір: " + Float.BYTES + " Байт");
        System.out.println("Мінімальне значення: " + Float.MIN_VALUE);
        System.out.println("Максимальне значення: " + Float.MAX_VALUE);

        System.out.println("Double:");
        System.out.println("Розмір: " + Double.BYTES + " Байт");
        System.out.println("Мінімальне значення: " + Double.MIN_VALUE);
        System.out.println("Максимальне значення: " + Double.MAX_VALUE);

        int ch_max = Character.MAX_VALUE;
        int ch_min = Character.MIN_VALUE;
        System.out.println("Char:");
        System.out.println("Розмір: " + Character.BYTES + " Байт");
        System.out.println("Мінімальне значення: " + ch_min);
        System.out.println("Максимальне значення:" + ch_max); // Зробив через змінні, тому що інакше Джава не хотіла виводити максимальне та мінімальне значення

        System.out.print("Введіть byte: ");
        String inputByte = scnr.nextLine();
        System.out.println("Ваш рядок, конвертований в byte: " + Byte.parseByte(inputByte));

        System.out.print("Введіть short: ");
        String inputShort = scnr.nextLine();
        System.out.println("Ваш рядок, конвертований в short: " + Short.parseShort(inputShort));

        System.out.print("Введіть int: ");
        String inputInt = scnr.nextLine();
        System.out.println("Ваш рядок, конвертований в int: " + Integer.parseInt(inputInt));

        System.out.print("Введіть long: ");
        String inputLong = scnr.nextLine();
        System.out.println("Ваш рядок, конвертований в long: " + Long.parseLong(inputLong));

        System.out.print("Введіть float: ");
        String inputFloat = scnr.nextLine();
        System.out.println("Ваш рядок, конвертований в float: " + Float.parseFloat(inputFloat));

        System.out.print("Введіть double: ");
        String inputDouble = scnr.nextLine();
        System.out.println("Ваш рядок, конвертований в double: " + Double.parseDouble(inputDouble));
    }
}
