import java.util.Arrays;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість кутів");
        int amount_of_angles = sc.nextInt();
        System.out.println("Введіть кути");
        int angles_sum = 0;
        int correct_sum_of_angles = 180 * (amount_of_angles -2);
        int[] angles = new int [amount_of_angles];
        for (int i=0; i<amount_of_angles; i++){
            angles[i] = sc.nextInt();
            angles_sum += angles[i];
        }
        if (angles_sum == correct_sum_of_angles){
            System.out.println("Такий многокутник може існувати, бо сума кутів дорівнює 180*(кількість кутів -2), у даному випадку: " +angles_sum);
        }
        else {
            System.out.println("Такий многокутник НЕ може існувати, бо сума кутів НЕ дорівнює 180*(кількість кутів-2), але у даному випадку вона дорівнює: " + angles_sum);
            System.out.println("При такому многокутнику з такою кількістю кутів, вона повинна дорівнювати: " + correct_sum_of_angles);
        }
        System.out.println("Введені кути:");
        System.out.println(Arrays.toString(angles));
    }
}
