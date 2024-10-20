import java.util.Scanner;
import java.lang.Math; //Імпортую сканер та бібліотеку Math

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double func;
        System.out.println("Введіть значення a:");
        Double a = sc.nextDouble();
        System.out.println("Введіть значення b:");
        Double b = sc.nextDouble();
        System.out.println("Введіть значення X:"); //Запрошую значення а, b та x
        Double x = sc.nextDouble();

        if (x>-2 && x<10){
            func = Math.sqrt(b * x + 3);
            System.out.println("f(x) = sqrt(b*x+3) = " + func); //Перший випадок, де х більше двух да менше 10
        }
        else if (x == 10){
            func = Math.abs(Math.pow(x, 2) - a*b*x + 7);
            System.out.println("f(x) = |x^2 - a*b*x +7| = " + func); //Другий випадок, де х дорівнює 10
        }
        else if(x>10){
            func=Math.cos(x-1);
            System.out.println("f(x) = cos(x-1) = " + func); //Третій випадок, де x більше 10
        }
        else {
            System.out.println("Функція для X < -2 не задана умовою");
        }

    }
}