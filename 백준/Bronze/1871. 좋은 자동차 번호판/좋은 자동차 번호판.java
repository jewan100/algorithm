import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = 0; i < N; i++) {
            String carNumber = br.readLine();
            String[] nubers = carNumber.split("-");

            String c1 = String.valueOf(nubers[0].charAt(0));
            String c2 = String.valueOf(nubers[0].charAt(1));
            String c3 = String.valueOf(nubers[0].charAt(2));
            int one = 0;
            int two = 0;
            int three = 0;

            for (int j = 0; j < alphabet.length; j++) {
                if (c1.equals(alphabet[j])) {
                    one = j;
                }
                if (c2.equals(alphabet[j])) {
                    two = j;
                }
                if (c3.equals(alphabet[j])) {
                    three = j;
                }
            }

            one = one * 26 * 26;
            two = two * 26;
            int total = one + two + three;
            int num = Integer.valueOf(nubers[1]);
            int result = 0;

            if (num > total) {
                result = num - total;
            } else if (num < total) {
                result = total - num;
            } else {
                result = 0;
            }

            if (result >= 0 && result <= 100) {
                System.out.println("nice");
            } else {
                System.out.println("not nice");
            }
        }
    }
}