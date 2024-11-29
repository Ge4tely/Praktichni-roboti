import java.util.Arrays;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        double [][] numbers = new double[5][5];
        Random r = new Random();
        System.out.println("Згенерований масив:");
        for (int i=0; i< numbers.length; i++){
            for (int j=0; j<numbers.length; j++){
                numbers[i][j] = r.nextDouble();
            }
            System.out.println(Arrays.toString(numbers[i]));
        }
        System.out.println("Згенерований масив, але кожний елемент з непарним індексом строки чи стовпця замінено на його кв корінь:");
        for (int i=0; i< numbers.length; i++){
            for (int j=0; j<numbers.length; j++){
                if (i%2!=0 || j%2!=0){
                    numbers[i][j] = Math.sqrt(numbers[i][j]);
                }
            }
            System.out.println(Arrays.toString(numbers[i]));
        }
    }
}