import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int result = 0;
        int min = 100001;
        for (int i = l; i <= r; i++) {
            if (min > Math.abs(x - i)) {
                min = Math.abs(x - i);
                result = i;
            }
        }

        System.out.println(result);
    }
}