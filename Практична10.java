import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static String[][] userbase = new String[16][2];
    public static Scanner scanner = new Scanner(System.in);
    public static char[] specialSymbols = new char[25];
    public static char[] symbols = new char[95];
    public static String[] bannedWords = new String[5];
    public static boolean isLoggedIn;
    public static int userID;
    public static void userbaseOutput(){
        for (int i = 0; i < 15; i++) {
            System.out.print(userbase[i][0]);
            System.out.println();
        }
    }
    public static void adminUserbaseOutput(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(userbase[i][j]);
            }
            System.out.println();
        }
    }
    public static void addingNewUser() {
        userbaseOutput();
        System.out.println("Введіть номер незайнятої клітинки");
        int numberChosen = 0;
        try {
            numberChosen = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Вводіть тільки числа");
        }
        System.out.println("Введіть ім'я нового користувача");
        userbase[numberChosen - 1][0] = numberChosen + ". " + getValidName() + " ";
        System.out.println("Введіть пароль нового користувача");
        userbase[numberChosen - 1][1] = numberChosen + ". " + getValidPass();
        userbaseOutput();
    }
    public static void deleteUser(){
        userbaseOutput();
        System.out.println("Введіть номер користувача для видалення:");
        int numberChosen = scanner.nextInt();
        if(userbase[numberChosen - 1][0].equals(numberChosen + ". empty ")){
            System.out.println("Користувача не існує");
        }else{
            userbase[numberChosen - 1][0] = numberChosen + ". empty ";
            System.out.println("Користувача видалено");
        }
    }
    public static boolean login(){
        scanner.nextLine();
        System.out.println("Введіть ім'я користувача");
        String input = scanner.nextLine();
        int userID =-1;
        for(int i = 0; i<15; i++){
            if (userbase[i][0].equals(i+1 + ". " + input + " ")){
                userID = i;
            }
        }
        if (userID == -1){
            System.out.println("Ім'я не знайдено");
            return false;
        }
        while (true) {
            try {
                System.out.println("Введіть пароль:");
                if (userbase[userID][1].equals(userID+1 + ". " + scanner.nextLine())) {
                    System.out.println("Ви успішно залогінились");
                    System.out.println("Оберіть дію для вашого користувача");
                    return true;
                } else {
                    System.out.println("Неправильний пароль");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Введена строка пуста. Спробуйте знову");
            }
        }
    }
    public static void loggedIn(){
        do {
        System.out.println("1. Змінити ім'я користувача");
        System.out.println("2. Змінити пароль користувача");
        System.out.println("3. Разлогінитись");
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Введіть нове ім'я вашого користувача");
                        userbase[userID][0] = userID + 1 + ". " + getValidName() + " ";
                        break;
                    case 2:
                        System.out.println("Введіть новий пароль вашого користувача");
                        userbase[userID][1] = userID + 1 + ". " + getValidPass();
                        break;
                    case 3:
                        isLoggedIn = false;
                        System.out.println("Ви успішно разлогінились");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Вводіть тільки цифри");
            }
        }while(isLoggedIn);
    }
    public static String getValidName(){
        boolean isValid = false;
        boolean isLongEnough;
        boolean hasNoSpaces;
        String name = "";
        scanner.nextLine();
        do{
            try {
                name = scanner.nextLine();
            }
            catch(NoSuchElementException e){
                System.out.println("Введена строка пуста. Спробуйте знову");
                continue;
            }
            if (name.length() < 5){
                System.out.println("Недостатня довжина");
                isLongEnough = false;
            }
            else{
                isLongEnough = true;
            }
            if (name.contains(" ")){
                System.out.println("Не має містити пробілів");
                hasNoSpaces = false;
            }
            else{
                hasNoSpaces = true;
            }
            if (hasNoSpaces && isLongEnough){
                System.out.println("Введене ім'я прийнято!");
                isValid = true;
            }
        }while(!isValid);
        return name;
    }
    public static String getValidPass(){
        boolean isValid = false;
        boolean hasSpecialSymbol = false;
        boolean hasThreeNumbers = false;
        boolean hasNoSpaces;
        boolean hasNoBannedWords = false;
        boolean isLongEnough;
        int count=0;
        String password = "";
        specialSymbols = "!\"#$%&'()+,-./:;<=>?@[\\]^_`{|}~".toCharArray();
        bannedWords = "admin pass password qwerty ytrewq".split(" ");
        for (char i = 33; i<127; i++){
            symbols[i-33] = i;
        }
        do{
            try {
                password = scanner.nextLine();
            }
            catch(NoSuchElementException e){
                System.out.println("Введена строка пуста. Спробуйте знову");
                continue;
            }
            if (password.length() < 10){
                System.out.println("Недостатня довжина. Як мінімум 10 символів");
                isLongEnough = false;
            }
            else{
                isLongEnough = true;
            }
            if (password.contains(" ")){
                System.out.println("Пароль не має містити пробілів");
                hasNoSpaces = false;
            }
            else{
                hasNoSpaces = true;
            }
            for(int i=0; i<bannedWords.length; i++){
                if (password.contains(bannedWords[i])){
                    hasNoBannedWords = false;
                    System.out.println("Пароль не може мати заборонених слів, таких як admin, pass, password, qwerty, ytrewq");
                    break;
                }
                else {
                    hasNoBannedWords = true;
                }
            }
            for(int i=0; i<specialSymbols.length; i++){
                if (password.contains(String.valueOf(specialSymbols[i]))){
                    hasSpecialSymbol = true;
                    break;
                }
                else {
                    hasSpecialSymbol = false;
                }
            }
            if(!hasSpecialSymbol){
                System.out.println("Пароль має містити хоча б один спеціальний символ");
            }

            for (char ch : password.toCharArray()) {
                if (Character.isDigit(ch)) {
                    count++;
                    if (count >= 3) {
                        hasThreeNumbers = true;
                        break;
                    }
                }
            }
            if(!hasThreeNumbers){
                System.out.println("Пароль має містити як мінімум три цифри");
            }
            if (hasNoSpaces && hasNoBannedWords && hasSpecialSymbol && hasThreeNumbers && isLongEnough){
                System.out.println("Введений пароль прийнято!");
                isValid = true;
            }
        }while(!isValid);
        return password;
    }

    public static void main(String[] args) {
        for (int i = 0; i<15; i++){
            for (int j = 0; j<2; j++){
                userbase[i][j] = i+1 + ". empty ";
            }
        }
        userbase[15][0] = "admin";
        userbase[15][1] = "admin";
        boolean running = true;

        while(running) {
            System.out.println("Введіть номер що б вибрати дію:");
            System.out.println("1. Логін користувача");
            System.out.println("2. Додавання користувача");
            System.out.println("3. Видалення користувача");
            System.out.println("4. Виведення всіх існуючих користувачів");
            System.out.println("5. Вийти з програми");
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        isLoggedIn = login();
                        if (isLoggedIn) {
                            loggedIn();
                        }
                        break;
                    case 2:
                        addingNewUser();
                        break;
                    case 3:
                        deleteUser();
                        break;
                    case 4:
                        userbaseOutput();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Завершення програми...");
                        break;
                    case 6:
                        adminUserbaseOutput();
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Вводіть тільки цифри");
            }
        }
    }
}