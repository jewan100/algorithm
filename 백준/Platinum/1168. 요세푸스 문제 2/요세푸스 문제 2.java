public class Main {

	static int[] tree;

	public static void main(String[] args) throws Exception {
		int n = read(), k = read();
		tree = new int[n << 2];
		build(1, 1, n);
		StringBuilder sb = new StringBuilder("<");
		int x = 1;
		for (int i = n; i > 0; i--) {
			x = (x + k - 2) % i + 1;
			int y = query(1, 1, n, x);
			sb.append(y);
			update(1, 1, n, y, -1);
			if (i > 1)
				sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}

	private static int build(int idx, int s, int e) {
		if (s == e)
			return tree[idx] = 1;
		int m = (s + e) >> 1;
		return tree[idx] = build(idx << 1, s, m) + build((idx << 1) + 1, m + 1, e);
	}

	private static int update(int idx, int s, int e, int pos, int val) {
		if (s == e)
			return tree[idx] += val;
		int m = (s + e) >> 1;
		if (pos <= m)
			return tree[idx] = update(idx << 1, s, m, pos, val) + tree[(idx << 1) + 1];
		return tree[idx] = tree[idx << 1] + update((idx << 1) + 1, m + 1, e, pos, val);
	}

	private static int query(int idx, int s, int e, int pos) {
		if (s == e)
			return s;
		int m = (s + e) >> 1, lCnt = tree[idx << 1];
		if (pos <= lCnt)
			return query(idx << 1, s, m, pos);
		return query((idx << 1) + 1, m + 1, e, pos - lCnt);
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