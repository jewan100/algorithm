public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			parent[i] = i;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int op = read(), a = read(), b = read();
			if (op == 0)
				union(a, b);
			else if (find(a) == find(b))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return parent[x];
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX == rootY)
			return;
		parent[rootY] = rootX;
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
