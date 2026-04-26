import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a + b == 0) break;
            int cnt = 0;
            int add = 0;
            while (a != 0 || b != 0) {
                int aM = a % 10;
                int bM = b % 10;
                a /= 10;
                b /= 10;
                if (aM + bM + add >= 10) {
                    cnt++;
                    add = 1;
                } else add = 0;
            }
            System.out.println(cnt);
        }
    }
}