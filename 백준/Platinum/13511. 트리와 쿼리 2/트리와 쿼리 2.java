import java.util.ArrayList;

public class Main {

	static ArrayList<ArrayList<int[]>> g = new ArrayList<>();
	static int[][] p;
	static long[] di;
	static int[] de;
	static boolean[] v;
	static int n, l;

	public static void main(String[] args) throws Exception {
		n = read();
		l = 1;
		while ((1 << l) <= n)
			l++;
		for (int i = 0; i < n + 1; i++)
			g.add(new ArrayList<>());
		for (int i = 0; i < n - 1; i++) {
			int u = read(), v = read(), w = read();
			g.get(u).add(new int[] { v, w });
			g.get(v).add(new int[] { u, w });
		}
		p = new int[n + 1][l];
		di = new long[n + 1];
		de = new int[n + 1];
		v = new boolean[n + 1];
		dfs(0, 1, 0, 0);
		build();
		StringBuilder sb = new StringBuilder();
		int m = read();
		for (int i = 0; i < m; i++) {
			int op = read(), u = read(), v = read();
			if (op == 1)
				sb.append(getDistance(u, v));
			else {
				int k = read();
				sb.append(kth(u, v, k));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int depth, int cur, int parent, long weight) {
		v[cur] = true;
		p[cur][0] = parent;
		di[cur] = weight;
		de[cur] = depth;
		for (int[] nxt : g.get(cur))
			if (!v[nxt[0]])
				dfs(depth + 1, nxt[0], cur, weight + nxt[1]);
	}

	private static void build() {
		for (int j = 1; j < l; j++)
			for (int i = 1; i < n + 1; i++) {
				int m = p[i][j - 1];
				if (m == 0)
					continue;
				p[i][j] = p[m][j - 1];
			}
	}

	private static int getLca(int u, int v) {
		if (de[u] < de[v]) {
			int t = u;
			u = v;
			v = t;
		}
		int diff = de[u] - de[v];
		for (int i = 0; i < l; i++)
			if (((diff >> i) & 1) == 1)
				u = p[u][i];
		if (u == v)
			return u;

		for (int i = l - 1; i >= 0; i--)
			if (p[u][i] != p[v][i]) {
				u = p[u][i];
				v = p[v][i];
			}
		return p[u][0];
	}

	private static long getDistance(int u, int v) {
		int lca = getLca(u, v);
		return di[u] + di[v] - 2 * di[lca];
	}

	private static int kth(int u, int v, int k) {
		int lca = getLca(u, v);
		int du = de[u] - de[lca];
		int dv = de[v] - de[lca];
		if (k - 1 <= du)
			return up(u, k - 1);
		int re = du + dv - (k - 1);
		return up(v, re);
	}

	private static int up(int u, int dist) {
		for (int i = 0; i < l; i++)
			if (((dist >> i) & 1) == 1)
				u = p[u][i];
		return u;
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
