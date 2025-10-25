import java.util.ArrayList;

public class Main {

	static int n;
	static int[] arr;
	static int[][] dp;
	static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		n = read();
		arr = new int[n + 1];
		dp = new int[2][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++)
			edges.add(new ArrayList<>());
		for (int i = 1; i < n + 1; i++)
			arr[i] = read();
		for (int i = 0; i < n - 1; i++) {
			int u = read(), v = read();
			edges.get(u).add(v);
			edges.get(v).add(u);
		}
		visited[1] = true;
		recursive(1);
		System.out.println(Math.max(dp[0][1], dp[1][1]));
	}

	private static void recursive(int u) {
		dp[1][u] = arr[u];
		for (int v : edges.get(u)) {
			if (visited[v])
				continue;
			visited[v] = true;
			recursive(v);
			dp[0][u] = dp[0][u] + Math.max(dp[0][v], dp[1][v]);
			dp[1][u] = dp[1][u] + dp[0][v];
		}
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