public class Main {

	static final int SIZE = 1_000_001;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		int n = read();
		tree = new int[SIZE << 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int a = read();
			if (a == 1) {
				int b = read();
				sb.append(query(1, 1, SIZE, b)).append("\n");
			} else {
				int b = read(), c = read();
				update(1, 1, SIZE, b, c);
			}
		}
		System.out.println(sb);
	}

	private static void update(int idx, int s, int e, int pos, int val) {
		if (pos < s || e < pos)
			return;
		tree[idx] += val;
		if (s == e)
			return;
		int m = (s + e) >> 1;
		if (pos <= m)
			update(idx << 1, s, m, pos, val);
		else
			update((idx << 1) + 1, m + 1, e, pos, val);
	}

	private static int query(int idx, int s, int e, int pos) {
		if (s == e) {
			update(1, 1, SIZE, s, -1);
			return s;
		}
		int m = (s + e) >> 1;
		if (pos <= tree[idx << 1])
			return query(idx << 1, s, m, pos);
		else
			return query((idx << 1) + 1, m + 1, e, pos - tree[idx << 1]);
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