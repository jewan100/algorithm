public class Main {

	static int[] lazy;

	public static void main(String[] args) throws Exception {
		int n = read();
		int[] arr = new int[n << 2];
		lazy = new int[n << 2];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		int m = read();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int op = read();
			if (op == 1) {
				int l = read(), r = read(), val = read();
				update(1, 0, n - 1, l, r, val);
			} else {
				int idx = read();
				sb.append(query(1, 0, n - 1, idx) ^ arr[idx]).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void update(int idx, int s, int e, int l, int r, int val) {
		if (r < s || e < l)
			return;
		if (l <= s && e <= r) {
			lazy[idx] ^= val;
			return;
		}
		int m = (s + e) >> 1;
		update(idx << 1, s, m, l, r, val);
		update((idx << 1) + 1, m + 1, e, l, r, val);
	}

	private static int query(int idx, int s, int e, int pos) {
		if (s == e)
			return lazy[idx];
		int m = (s + e) >> 1;
		if (pos <= m)
			return lazy[idx] ^ query((idx << 1), s, m, pos);
		else
			return lazy[idx] ^ query((idx << 1) + 1, m + 1, e, pos);
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