import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();

            if (s.equals("***")) {
                break;
            }

            StringBuffer sb = new StringBuffer(s);
            String reverse = sb.reverse().toString();

            System.out.println(reverse);

        }
    }
}