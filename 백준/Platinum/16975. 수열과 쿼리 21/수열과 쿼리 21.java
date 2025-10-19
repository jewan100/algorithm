public class Main {

	static long[] arr;
	static long tree[], lazy[];

	public static void main(String[] args) throws Exception {
		int n = read();
		arr = new long[n];
		tree = new long[n << 2];
		lazy = new long[n << 2];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		build(1, 0, n - 1);
		int m = read();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int op = read();
			if (op == 1) {
				int l = read() - 1, r = read() - 1, val = read();
				update(1, 0, n - 1, l, r, val);
			} else {
				int x = read() - 1;
				sb.append(query(1, 0, n - 1, x, x)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static long build(int idx, int s, int e) {
		if (s == e)
			return tree[idx] = arr[s];
		int m = (s + e) >> 1;
		return tree[idx] = build(idx << 1, s, m) + build((idx << 1) + 1, m + 1, e);
	}

	private static long update(int idx, int s, int e, int l, int r, long val) {
		if (lazy[idx] != 0) {
			apply(idx, s, e, lazy[idx]);
			lazy[idx] = 0;
		}
		if (r < s || e < l)
			return tree[idx];
		if (l <= s && e <= r) {
			apply(idx, s, e, val);
			return tree[idx];
		}
		int m = (s + e) >> 1;
		return tree[idx] = update(idx << 1, s, m, l, r, val) + update((idx << 1) + 1, m + 1, e, l, r, val);
	}

	private static long query(int idx, int s, int e, int l, int r) {
		if (lazy[idx] != 0) {
			apply(idx, s, e, lazy[idx]);
			lazy[idx] = 0;
		}
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r) + query((idx << 1) + 1, m + 1, e, l, r);
	}

	private static void apply(int idx, int s, int e, long val) {
		tree[idx] += (e - s + 1) * val;
		if (s != e) {
			lazy[idx << 1] += val;
			lazy[(idx << 1) + 1] += val;
		}
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