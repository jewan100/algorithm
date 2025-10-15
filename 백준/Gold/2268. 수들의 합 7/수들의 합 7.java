public class Main {

	static long[] tree;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		tree = new long[n << 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int a = read(), b = read(), c = read();
			if (a == 0) {
				int l = Math.min(b, c) - 1, r = Math.max(b, c) - 1;
				sb.append(sum(1, 0, n - 1, l, r)).append("\n");
			} else
				modify(1, 0, n - 1, b - 1, c);
		}
		System.out.println(sb);
	}

	private static long sum(int idx, int s, int e, int l, int r) {
		if (l > e || r < s)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		if (s == e)
			return tree[idx];
		int m = (s + e) >> 1;
		return sum((idx << 1), s, m, l, r) + sum((idx << 1) + 1, m + 1, e, l, r);
	}

	private static void modify(int idx, int s, int e, int pos, int val) {
		if (s == e) {
			tree[idx] = val;
			return;
		}
		int m = (s + e) >> 1;
		if (pos <= m)
			modify(idx << 1, s, m, pos, val);
		else
			modify((idx << 1) + 1, m + 1, e, pos, val);
		tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
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