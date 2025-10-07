import java.util.PriorityQueue;

public class Main {

	static int[] parent;

	static class Edge {
		int s, e;
		double len;

		Edge(int s, int e, double len) {
			this.s = s;
			this.e = e;
			this.len = len;
		}
	}

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++)
			parent[i] = i;
		int[][] loc = new int[n + 1][2];
		for (int i = 1; i < n + 1; i++) {
			loc[i][0] = read();
			loc[i][1] = read();
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.len, o2.len));
		for (int i = 1; i < n; i++)
			for (int j = i + 1; j < n + 1; j++) {
				double len = Math.sqrt(Math.pow(loc[i][0] - loc[j][0], 2) + Math.pow(loc[i][1] - loc[j][1], 2));
				pq.offer(new Edge(i, j, len));
			}
		for (int i = 0; i < m; i++) {
			int u = read(), v = read();
			union(u, v);
		}
		double totalLen = 0;
		int cnt = 0;
		while (!pq.isEmpty() && cnt < n - 1) {
			Edge edge = pq.poll();
			if (union(edge.s, edge.e)) {
				cnt++;
				totalLen += edge.len;
			}
		}
		System.out.printf("%.2f", totalLen);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return parent[x];
		return parent[x] = find(parent[x]);
	}

	private static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX == rootY)
			return false;
		parent[rootX] = rootY;
		return true;
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