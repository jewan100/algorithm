import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = read(), b = read();
            graph.get(b).add(a);
        }

        int maxCnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int cnt = dfs(i);
            if (cnt > maxCnt) {
                maxCnt = cnt;
                sb = new StringBuilder().append(i).append(" ");
            } else if (cnt == maxCnt)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static int dfs(int start) {
        visited[start] = true;
        int cnt = 1;
        for (int next : graph.get(start))
            if (!visited[next])
                cnt += dfs(next);
        return cnt;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
