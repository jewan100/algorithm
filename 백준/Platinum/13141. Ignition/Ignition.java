import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static final long INF = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		double[][] dist = new double[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		ArrayList<int[]> edges = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int u = read(), v = read(), w = read();
			edges.add(new int[]{u, v, w});
			dist[u][v] = Math.min(dist[u][v], w);
			dist[v][u] = Math.min(dist[v][u], w);
		}
		for (int k = 1; k < n + 1; k++)
			for (int i = 1; i < n + 1; i++)
				for (int j = 1; j < n + 1; j++)
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];

		double minTime = INF;
		for (int i = 1; i < n + 1; i++) {
			double totalTime = 0;
			for (int[] edge : edges) {
				int u = edge[0], v = edge[1], w = edge[2];
				totalTime = Math.max(totalTime, dist[i][u] + dist[i][v] + w);
			}
			minTime = Math.min(minTime, totalTime);
		}

		System.out.printf("%.1f", minTime / 2.0);
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