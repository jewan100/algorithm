import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int H = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE, h = 0, m = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i % 24 != H || j % 60 != M) continue;
                int e = calc(i / 10, i % 10) + calc(i % 10, j / 10) + calc(j / 10, j % 10);

                if (min > e) {
                    min = e;
                    h = i;
                    m = j;
                }
            }
        }
        sb.append(h < 10 ? "0" : "").append(h).append(m < 10 ? ":0" : ":").append(m);

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(int a, int b) {
        return Math.abs(arr[a][0] - arr[b][0]) + Math.abs(arr[a][1] - arr[b][1]);
    }

}