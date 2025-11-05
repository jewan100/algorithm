public class Main {

	static int n, m;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		int t = read();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			n = read();
			m = read();
			int[] idx = new int[n + 1];
			tree = new int[(n + m) << 2];
			for (int i = 0; i < n; i++)
				idx[i + 1] = m + i;
			build(1, 0, n + m - 1);
			for (int i = 0; i < m; i++) {
				int p = read();
				sb.append(query(1, 0, n + m - 1, 0, idx[p] - 1)).append(" ");
				update(1, 0, n + m - 1, idx[p], -1);
				idx[p] = m - 1 - i;
				update(1, 0, n + m - 1, idx[p], 1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int build(int idx, int s, int e) {
		if (s == e)
			if (s >= m)
				return tree[idx] = 1;
			else
				return 0;
		int m = (s + e) >> 1;
		return tree[idx] = build(idx << 1, s, m) + build((idx << 1) + 1, m + 1, e);
	}

	private static int query(int idx, int s, int e, int l, int r) {
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r) + query((idx << 1) + 1, m + 1, e, l, r);
	}

	private static int update(int idx, int s, int e, int pos, int val) {
		if (s == e)
			return tree[idx] += val;
		int m = (s + e) >> 1;
		if (pos <= m)
			return tree[idx] = update(idx << 1, s, m, pos, val) + tree[(idx << 1) + 1];
		return tree[idx] = tree[idx << 1] + update((idx << 1) + 1, m + 1, e, pos, val);
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