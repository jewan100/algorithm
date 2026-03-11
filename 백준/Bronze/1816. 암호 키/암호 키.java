import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] S = new long[n];

        for (int i = 0; i < n; i++) {
            S[i] = Long.parseLong(br.readLine());
        }

        double maxValue = Math.pow(10, 6);

        for (int i = 0; i < n; i++) {
            long s = S[i];
            String result = "YES";
            for (long j = 2L; j <= maxValue; j++) {
                if (s % j == 0) {
                    result = "NO";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}