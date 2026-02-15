import java.util.Scanner;

public class Main {
    static double[] needPancake = {0.5, 0.5, 0.25, 0.0625, 0.5625};
    static int[] needTopping = {1, 30, 25, 10};

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            double canMake1 = 0;
            for (int j = 0; j < 5; j++) {
                int n = in.nextInt();
                n /= needPancake[j];
                if (j == 0 || n < canMake1) canMake1 = n;
            }
            int canMake2 = 0; 
            for (int j = 0; j < 4; j++) {
                int n = in.nextInt();
                canMake2 += (n / needTopping[j]);
            }
            System.out.println((int) Math.min(canMake1, canMake2));
        }
    }
}