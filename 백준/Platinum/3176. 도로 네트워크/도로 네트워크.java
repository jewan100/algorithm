import java.util.ArrayList;

public class Main {

	static class Node {
		int min, max;

		Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	static final int INF = 1_000_000_007;
	static int n, l;
	static ArrayList<ArrayList<int[]>> g = new ArrayList<>();
	static int[][] p;
	static int[] de;
	static Node[][] di;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		n = read();
		for (int i = 0; i < n + 1; i++)
			g.add(new ArrayList<>());
		for (int i = 0; i < n - 1; i++) {
			int a = read(), b = read(), c = read();
			g.get(a).add(new int[] { b, c });
			g.get(b).add(new int[] { a, c });
		}
		l = 1;
		while ((1 << l) <= n)
			l++;
		p = new int[n + 1][l];
		de = new int[n + 1];
		di = new Node[n + 1][l];
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < l; j++)
				di[i][j] = new Node(INF, -INF);
		v = new boolean[n + 1];
		dfs(1, 0, 0, INF);
		build();
		int k = read();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			Node r = up(read(), read());
			sb.append(r.min).append(" ").append(r.max).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur, int depth, int parent, int weight) {
		v[cur] = true;
		p[cur][0] = parent;
		de[cur] = depth;
		if (parent != 0)
			di[cur][0] = new Node(weight, weight);
		for (int[] nxt : g.get(cur))
			if (!v[nxt[0]])
				dfs(nxt[0], depth + 1, cur, nxt[1]);
	}

	private static void build() {
		for (int j = 1; j < l; j++)
			for (int i = 1; i < n + 1; i++) {
				int m = p[i][j - 1];
				if (m == 0)
					continue;
				p[i][j] = p[m][j - 1];
				di[i][j] = merge(di[i][j - 1], di[m][j - 1]);
			}
	}

	private static Node up(int a, int b) {
		Node r = new Node(INF, -INF);
		if (de[a] < de[b]) {
			int t = a;
			a = b;
			b = t;
		}
		int diff = de[a] - de[b];
		for (int i = 0; i < l; i++)
			if (((diff >> i) & 1) == 1) {
				r = merge(r, di[a][i]);
				a = p[a][i];
			}

		for (int i = l - 1; i >= 0; i--)
			if (p[a][i] != p[b][i]) {
				r = merge(merge(r, di[a][i]), di[b][i]);
				a = p[a][i];
				b = p[b][i];
			}
		if (a == b)
			return r;
		return merge(merge(r, di[a][0]), di[b][0]);
	}

	private static Node merge(Node a, Node b) {
		return new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
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
