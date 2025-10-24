import java.util.ArrayList;

public class Main {

	static int n;
	static int[] parent;
	static int[] depth;
	static ArrayList<ArrayList<Integer>> tree;

	public static void main(String[] args) throws Exception {
		int t = read();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			n = read();
			parent = new int[n + 1];
			depth = new int[n + 1];
			tree = new ArrayList<>();
			for (int i = 0; i < n + 1; i++)
				tree.add(new ArrayList<>());
			for (int i = 0; i < n - 1; i++) {
				int a = read(), b = read();
				parent[b] = a;
				tree.get(a).add(b);
			}
			int root = 0;
			for (int i = 1; i < n + 1; i++)
				if (parent[i] == 0) {
					root = i;
					break;
				}
			dfs(root, 0);
			sb.append(lca(read(), read()));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int u, int d) {
		depth[u] = d;
		for (int v : tree.get(u))
			dfs(v, d + 1);
	}

	private static int lca(int a, int b) {
		int u = a, v = b;
		while (depth[u] != depth[v]) {
			if (depth[u] < depth[v])
				v = parent[v];
			else
				u = parent[u];
		}
		if (u == v)
			return u;
		while (parent[u] != parent[v]) {
			u = parent[u];
			v = parent[v];
		}
		return parent[u];
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