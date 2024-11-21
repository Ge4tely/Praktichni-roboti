import java.lang.Math;

public class task4 {
    public static void main(String[] args) {
        int size = 91;
        double[] sineValues = new double[size];
        String format = "%.4f";
        for (int i=0; i<size; i++){
            sineValues[i] = Math.sin(Math.toRadians(i));
            System.out.printf(format, sineValues[i]);
            System.out.print(" ");
            if (i%9==0){
                System.out.println();
            }
        }

    }
}
