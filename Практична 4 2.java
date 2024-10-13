import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть ціле число");
        int x = sc.nextInt();
        int flipped_x=0;
        int count = 0;
        int y =x;
        while(y != 0)
        {
            y = y / 10;
            count = count + 1;
        }
        for(;x != 0;)
        {
            int remainder = x % 10;
            flipped_x = flipped_x * 10 + remainder;
            x=x/10;
        }
        System.out.printf("Реверсоване число: %0" + count + "d%n", flipped_x);
    }
    }
