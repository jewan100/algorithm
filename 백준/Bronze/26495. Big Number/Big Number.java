import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] bigNumber = {
                {"0000", "   1", "2222", "3333", "4  4", "5555", "6666", "7777", "8888", "9999"},
                {"0  0", "   1", "   2", "   3", "4  4", "5",    "6",    "   7", "8  8", "9  9"},
                {"0  0", "   1", "2222", "3333", "4444", "5555", "6666", "   7", "8888", "9999"},
                {"0  0", "   1", "2",    "   3", "   4", "   5", "6  6", "   7", "8  8", "   9"},
                {"0000", "   1", "2222", "3333", "   4", "5555", "6666", "   7", "8888", "   9"}
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] n = br.readLine().toCharArray();

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(bigNumber[j][n[i] - '0']);

            }
            System.out.println();
        }
    }
}