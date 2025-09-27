import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains("17") && s.contains("18")) {
                System.out.println(s);
                System.out.println("both");
                System.out.println();
            } else if (s.contains("17")) {
                System.out.println(s);
                System.out.println("zack");
                System.out.println();
            } else if (s.contains("18")) {
                System.out.println(s);
                System.out.println("mack");
                System.out.println();
            } else {
                System.out.println(s);
                System.out.println("none");
                System.out.println();
            }
        }
    }
}