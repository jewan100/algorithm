public class Main {

	static int[] arr, parent;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read(), k = read();
		arr = new int[n + 1];
		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
			arr[i] = read();
		}
		for (int i = 0; i < m; i++)
			union(read(), read());
		int sum = 0;
		boolean[] v = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			int root = find(i);
			if (!v[root]) {
				sum += arr[root];
				v[root] = true;
			}
		}
		System.out.println(sum <= k ? sum : "Oh no");
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
		if (arr[rootX] <= arr[rootY])
			parent[rootY] = rootX;
		else
			parent[rootX] = rootY;
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
