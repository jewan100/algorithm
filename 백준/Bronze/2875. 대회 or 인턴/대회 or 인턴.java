import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int K = Integer.parseInt(split[2]);
        int answer = 0;
        while (N >= 2 && M >= 1 && (N + M) - K >= 3) {
            answer++;
            N -= 2;
            M--;
        }
        System.out.println(answer);
        br.close();
    }
}