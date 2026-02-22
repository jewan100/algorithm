import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }

            char alphabet = input.charAt(0);
            String sentence = input.substring(2);
            int count = 0;

            char target = Character.toLowerCase(alphabet);
            for (int i = 0; i < sentence.length(); i++) {
                if (Character.toLowerCase(sentence.charAt(i)) == target) {
                    count++;
                }
            }
            System.out.println(alphabet + " " + count);
        }
    }
}