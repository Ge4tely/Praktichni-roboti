import java.lang.Math; //Імпортуємо бібліотеку Math

public class Main {
    public static final double a = -0.5;
    public static final double b = 1.7;
    public static final double t = 0.44;
    public static final double temporary = -b * t;//Створюю константи для формули

    public static final double x = Math.pow(Math.E, temporary) * Math.sin(a*t+b) - Math.sqrt(Math.abs(b*t-a));
    public static final double y = b * Math.sin(a * Math.pow(t, 2) * Math.cos(2 * t)) - 1; //Оскільки х та y незмінні та залежать тільки від значення констант, їх теж роблю константами

    public static void main(String[] args) {
        System.out.println("Значення константи a: " + a);
        System.out.println("Значення константи b: " + b);
        System.out.println("Значення константи t: " + t);

        System.out.println("Формула розрахунку x: x = e^(-bt) * sin(at+b) - sqrt(|bt+a|)");
        System.out.println("Значення x:" + x); //Розраховуємо та виводимо значення Х

        System.out.println("Формула розрахунку y: y = b *  sin(a*t^2*cos(2t))-1");
        System.out.println("Значення y:" + y); //Розраховуємо та виводимо значення Y
    }
}