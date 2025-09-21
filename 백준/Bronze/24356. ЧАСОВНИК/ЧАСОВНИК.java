import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int time1 = t1 * 60 + m1; 
        int time2 = t2 * 60 + m2; 

        int m = 0; 
        int n = 0; 

        if (time1 > time2) { 
            m = (time2 + 60 * 24) - time1;
            n = (m - m % 30) / 30;
        } else if (time1 < time2) { 
            m = time2 - time1;
            n = (m - m % 30) / 30;
        }

        System.out.printf("%d %d", m, n);
    }
}