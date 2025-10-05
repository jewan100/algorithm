public class Main {

	static int[][] tree, arr;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		int n = read();
		tree = new int[n + 1][2];
		arr = new int[n + 1][2];
		boolean[] isChild = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			int u = read(), l = read(), r = read();
			tree[u][0] = l;
			tree[u][1] = r;
			if (l != -1)
				isChild[l] = true;
			if (r != -1)
				isChild[r] = true;
		}
		int root = 1;
		for (int i = 1; i <= n; i++)
			if (!isChild[i]) {
				root = i;
				break;
			}
		recursive(root, 1);
		int maxDepth = 1, maxWidth = 1;
		for (int i = 1; i <= n; i++) {
			if (arr[i][0] == 0)
				continue;
			int width = arr[i][1] - arr[i][0] + 1;
			if (width > maxWidth) {
				maxWidth = width;
				maxDepth = i;
			}
		}
		System.out.println(maxDepth + " " + maxWidth);
	}

	private static void recursive(int node, int depth) {
		if (node == -1)
			return;
		recursive(tree[node][0], depth + 1);
		cnt++;
		if (arr[depth][0] == 0)
			arr[depth][0] = cnt;
		arr[depth][1] = cnt;
		recursive(tree[node][1], depth + 1);
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return m ? ~n + 1 : n;
	}
}
