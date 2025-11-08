public class Main {

	static int size = 2_000_001;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		int n = read();
		tree = new int[size << 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int t = read(), x = read();
			if (t == 1)
				update(1, 0, size, x, 1);
			else {
				int y = query(1, 0, size, x);
				sb.append(y).append("\n");
				update(1, 0, size, y, -1);
			}
		}
		System.out.println(sb);
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
		int m = (s + e) >> 1;
		int lCnt = tree[idx << 1];
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