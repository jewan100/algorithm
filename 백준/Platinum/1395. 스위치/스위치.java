public class Main {

	static int[] tree;
	static boolean[] lazy;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		tree = new int[n << 2];
		lazy = new boolean[n << 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int op = read(), l = read() - 1, r = read() - 1;
			if (op == 0)
				update(1, 0, n - 1, l, r);
			else
				sb.append(query(1, 0, n - 1, l, r)).append("\n");
		}
		System.out.println(sb);
	}

	private static int update(int idx, int s, int e, int l, int r) {
		if (lazy[idx]) {
			apply(idx, s, e);
			lazy[idx] = false;
		}
		if (r < s || e < l)
			return tree[idx];
		if (l <= s && e <= r) {
			apply(idx, s, e);
			return tree[idx];
		}
		int m = (s + e) >> 1;
		return tree[idx] = update(idx << 1, s, m, l, r) + update((idx << 1) + 1, m + 1, e, l, r);
	}

	private static int query(int idx, int s, int e, int l, int r) {
		if (lazy[idx]) {
			apply(idx, s, e);
			lazy[idx] = false;
		}
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r) + query((idx << 1) + 1, m + 1, e, l, r);
	}

	private static void apply(int idx, int s, int e) {
		tree[idx] = (e - s + 1) - tree[idx];
		if (s != e) {
			lazy[idx << 1] = !lazy[idx << 1];
			lazy[(idx << 1) + 1] = !lazy[(idx << 1) + 1];
		}
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