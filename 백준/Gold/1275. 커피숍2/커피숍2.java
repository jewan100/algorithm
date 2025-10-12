public class Main {

	static class SegmentTree {
		long[] tree;
		int n;

		public SegmentTree(int[] arr) {
			n = arr.length;
			tree = new long[n << 2];
			build(arr, 1, 0, n - 1);
		}

		private void build(int[] arr, int idx, int s, int e) {
			if (s == e)
				tree[idx] = arr[s];
			else {
				int m = (s + e) >> 1;
				build(arr, idx << 1, s, m);
				build(arr, (idx << 1) + 1, m + 1, e);
				tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
			}
		}

		public long query(int x, int y) {
			int l = Math.min(x, y), r = Math.max(x, y);
			return query(1, 0, n - 1, l, r);
		}

		private long query(int idx, int s, int e, int l, int r) {
			if (r < s || e < l)
				return 0;
			if (l <= s && e <= r)
				return tree[idx];
			int m = (s + e) >> 1;
			long left = query(idx << 1, s, m, l, r);
			long right = query((idx << 1) + 1, m + 1, e, l, r);
			return left + right;
		}

		public void update(int pos, int val) {
			update(1, 0, n - 1, pos, val);
		}

		private void update(int idx, int s, int e, int pos, int val) {
			if (pos < s || pos > e)
				return;
			if (s == e) {
				tree[idx] = val;
				return;
			}
			int m = (s + e) >> 1;
			if (pos <= m)
				update(idx << 1, s, m, pos, val);
			else
				update((idx << 1) + 1, m + 1, e, pos, val);
			tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
		}
	}

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		SegmentTree segTree = new SegmentTree(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int x = read() - 1, y = read() - 1, a = read() - 1, b = read();
			sb.append(segTree.query(x, y)).append("\n");
			segTree.update(a, b);
		}
		System.out.println(sb);
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