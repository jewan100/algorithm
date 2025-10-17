import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE >> 1);
			dist[i][i] = 0;
		}
		for (int i = 0; i < n - 1; i++) {
			int u = read(), v = read(), w = read();
			dist[u][v] = dist[v][u] = w;
		}
		for (int k = 1; k < n + 1; k++)
			for (int i = 1; i < n + 1; i++)
				for (int j = 1; j < n + 1; j++)
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++)
			sb.append(dist[read()][read()]).append("\n");
		System.out.println(sb);
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