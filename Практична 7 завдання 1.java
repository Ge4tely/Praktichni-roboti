import java.util.Arrays;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть розмір найблільшого масиву");
        int size = sc.nextInt();
        int[][] array = new int [size][];
        for (int i = 0; i<array.length; ++i){
            array[i] = new int[i+1];
            for (int j=0; j<array[i].length; ++j){
                array[i][j] = i/(j+1);
            }
        }

        for (int i = 0; i<array.length; ++i){
            System.out.println(Arrays.toString(array[i]));
        }
        for (int i = array.length-2; i>=0; i--){
            System.out.println(Arrays.toString(array[i]));
        }

    }
}
