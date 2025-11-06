public class Main {

	static int n, k, SIZE = 65535;
	static int[] arr, tree;

	public static void main(String[] args) throws Exception {
		n = read();
		k = read();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		tree = new int[(SIZE + 1) << 2];
		for (int i = 0; i < k; i++)
			update(1, 0, SIZE, arr[i], 1);
		long sum = 0;
		int mid = (k + 1) >> 1;
		sum += query(1, 0, SIZE, mid);
		for (int i = k; i < n; i++) {
			update(1, 0, SIZE, arr[i - k], -1);
			update(1, 0, SIZE, arr[i], 1);
			sum += query(1, 0, SIZE, mid);
		}
		System.out.println(sum);
	}

	private static int update(int idx, int s, int e, int pos, int val) {
		if (s == e)
			return tree[idx] += val;
		int m = (s + e) >> 1;
		if (pos <= m)
			return tree[idx] = update(idx << 1, s, m, pos, val) + tree[(idx << 1) + 1];
		return tree[idx] = tree[idx << 1] + update((idx << 1) + 1, m + 1, e, pos, val);
	}

	private static int query(int idx, int s, int e, int kth) {
		if (s == e)
			return s;
		int m = (s + e) >> 1;
		if (tree[idx << 1] >= kth)
			return query(idx << 1, s, m, kth);
		return query((idx << 1) + 1, m + 1, e, kth - tree[idx << 1]);
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
