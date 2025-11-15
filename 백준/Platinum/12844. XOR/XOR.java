public class Main {

	static int n, m;
	static int[] arr, tree, lazy;

	public static void main(String[] args) throws Exception {
		n = read();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		tree = new int[n << 2];
		lazy = new int[n << 2];
		build(1, 0, n - 1);
		m = read();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int op = read();
			if (op == 1)
				update(1, 0, n - 1, read(), read(), read());
			else
				sb.append(query(1, 0, n - 1, read(), read())).append("\n");
		}
		System.out.println(sb);
	}

	private static int build(int idx, int s, int e) {
		if (s == e)
			return tree[idx] = arr[s];
		int m = (s + e) >> 1;
		return tree[idx] = build(idx << 1, s, m) ^ build((idx << 1) + 1, m + 1, e);
	}

	private static int update(int idx, int s, int e, int l, int r, int val) {
		if (lazy[idx] != 0)
			apply(idx, s, e);
		if (r < s || e < l)
			return tree[idx];
		if (l <= s && e <= r) {
			lazy[idx] ^= val;
			apply(idx, s, e);
			return tree[idx];
		}
		int m = (s + e) >> 1;
		return tree[idx] = update(idx << 1, s, m, l, r, val) ^ update((idx << 1) + 1, m + 1, e, l, r, val);
	}

	private static void apply(int idx, int s, int e) {
		if (s != e) {
			lazy[idx << 1] ^= lazy[idx];
			lazy[(idx << 1) + 1] ^= lazy[idx];
		}
		if ((e - s + 1) % 2 == 1)
			tree[idx] ^= lazy[idx];
		lazy[idx] = 0;
	}

	private static int query(int idx, int s, int e, int l, int r) {
		if (lazy[idx] != 0)
			apply(idx, s, e);
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r) ^ query((idx << 1) + 1, m + 1, e, l, r);
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