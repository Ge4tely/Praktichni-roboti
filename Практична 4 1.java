import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x >= 1 && x<3) {
            x = 2;
        }
        switch (x){
            case 3:
                System.out.println("f(x)=|ax^2+b+x|");
                break;
            case 2:
                System.out.println("f(x)=9/(ax)");
                break;
            default:
                System.out.println("Немає значення");

        }
    }
}
