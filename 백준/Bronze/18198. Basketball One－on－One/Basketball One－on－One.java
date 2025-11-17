
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String input = br.readLine();

        int scoreA = 0;
        int scoreB = 0;
        char winner = 'C';

        for (int i = 0; i < input.length(); i += 2) {

            final char player = input.charAt(i);
            final int currentScore = Integer.parseInt(String.valueOf(input.charAt(i + 1)));

            if (player == 'A') {
                scoreA += currentScore;
            } else if (player == 'B') {
                scoreB += currentScore;
            } else {
                throw new RuntimeException();
            }
            if (scoreA > 10 || scoreB > 10) {
                if (scoreA - 1 != scoreB && scoreB - 1 != scoreA) {
                    if (scoreA < scoreB) {
                        winner = 'B';
                        break;
                    } else if (scoreA > scoreB) {
                        winner = 'A';
                        break;
                    }
                }
            }
        }
        System.out.print(winner);
    }
}