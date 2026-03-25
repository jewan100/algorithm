import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        int score = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < r; j++) score += rps(s.charAt(j), arr[i].charAt(j));
        }

        sb.append(score).append("\n");
        score = 0;

        for (int i = 0; i < r; i++) {
            int a = 0, b = 0, c = 0;
            for (int j = 0; j < n; j++) {
                a += rps('R', arr[j].charAt(i));
                b += rps('P', arr[j].charAt(i));
                c += rps('S', arr[j].charAt(i));
            }
            score += Math.max(a, Math.max(b, c));
        }

        bw.write(sb.append(score).append("\n").toString());
        bw.flush();
    }

    private static int rps(char a, char b) {
        if (a == b) return 1;

        if (a == 'R') {
            if (b == 'P') return 0;
            return 2;
        } else if (a == 'P') {
            if (b == 'R') return 2;
            return 0;
        } else {
            if (b == 'R') return 0;
            return 2;
        }
    }

}