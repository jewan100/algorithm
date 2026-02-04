import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int j = 1;
        while (count <= b) {
            for (int i = 1; i <= j; i++) {
                sb.append(j + " ");
                count++;
            }
            j++;
        }
        String s = sb.toString();
        st = new StringTokenizer(s);
        int sum = 0;
        for (int i = 1; i < a; i++) {
            st.nextToken();
        }
        for (int i = a; i <= b; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        System.out.print(sum);
    }
}