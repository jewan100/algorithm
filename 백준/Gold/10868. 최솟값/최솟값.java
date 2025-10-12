public class Main {

	static class SegmentTree {
		int[] tree;
		int n;

		public SegmentTree(int[] arr) {
			n = arr.length;
			tree = new int[n << 2];
			build(arr, 1, 0, n - 1);
		}

		private void build(int[] arr, int idx, int s, int e) {
			if (s == e)
				tree[idx] = arr[s];
			else {
				int m = (s + e) >> 1;
				build(arr, idx << 1, s, m);
				build(arr, (idx << 1) + 1, m + 1, e);
				tree[idx] = Math.min(tree[idx << 1], tree[(idx << 1) + 1]);
			}
		}

		public int query(int l, int r) {
			return query(1, 0, n - 1, l, r);
		}

		private int query(int idx, int s, int e, int l, int r) {
			if (r < s || e < l)
				return Integer.MAX_VALUE;
			if (l <= s && e <= r)
				return tree[idx];
			int m = (s + e) >> 1;
			int left = query(idx << 1, s, m, l, r);
			int right = query((idx << 1) + 1, m + 1, e, l, r);
			return Math.min(left, right);
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
			int a = read() - 1, b = read() - 1;
			sb.append(segTree.query(a, b)).append("\n");
		}
		System.out.println(sb);
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