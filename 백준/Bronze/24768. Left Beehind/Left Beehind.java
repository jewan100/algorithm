import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0) {
                break;
            }

            if (x + y == 13) {
                System.out.println("Never speak again.");
            } else if (x > y) {
                System.out.println("To the convention.");
            } else if (x < y) {
                System.out.println("Left beehind.");
            } else {
                System.out.println("Undecided.");
            }
        }
    }
}