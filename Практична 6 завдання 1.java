import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random r = new Random();
            System.out.println("Введіть довжину масиву:");
            int length = sc.nextInt();
            int[] array = new int [length];
            int odd_amount = 0;
            int even_amount = 0;
            for (int i=0; i<length; i++){
                array[i] = r.nextInt(2000) - 1000;
                if (array[i] % 2 == 0){
                    even_amount+=1;
                }
                else{
                    odd_amount+=1;
                }
            }
            System.out.println(Arrays.toString(array));
            System.out.println("Кількість парних чисел: " + even_amount);
            System.out.println("Кількість непарних чисел: " + odd_amount);
        }
    }