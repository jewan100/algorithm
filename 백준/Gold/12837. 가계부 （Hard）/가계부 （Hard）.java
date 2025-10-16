public class Main {

	static long[] tree;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		tree = new long[n << 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int op = read();
			if (op == 1) {
				int p = read(), x = read();
				update(1, 0, n - 1, p - 1, x);
			} else {
				int p = read(), q = read();
				sb.append(query(1, 0, n - 1, p - 1, q - 1)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void update(int idx, int s, int e, int pos, int val) {
		if (s == e) {
			tree[idx] += val;
			return;
		}
		int m = (s + e) >> 1;
		if (pos <= m)
			update(idx << 1, s, m, pos, val);
		else
			update((idx << 1) + 1, m + 1, e, pos, val);
		tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
	}

	private static long query(int idx, int s, int e, int l, int r) {
		if (l > e || s > r)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r) + query((idx << 1) + 1, m + 1, e, l, r);
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