import java.util.ArrayList;

public class Main {

	static int n, m;
	static int[] arr;
	static ArrayList<ArrayList<Integer>> tree;

	public static void main(String[] args) throws Exception {
		n = read();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		tree = new ArrayList<>(n << 2);
		for (int i = 0; i < n << 2; i++)
			tree.add(new ArrayList<>());
		build(1, 0, n - 1);
		for (int i = 0; i < n << 2; i++)
			tree.get(i).sort((o1, o2) -> o1 - o2);
		StringBuilder sb = new StringBuilder();
		m = read();
		for (int i = 0; i < m; i++) {
			int l = read() - 1, r = read() - 1, k = read();
			sb.append(query(1, 0, n - 1, l, r, k)).append("\n");
		}
		System.out.println(sb);
	}

	private static void build(int idx, int s, int e) {
		if (s == e) {
			tree.get(idx).add(arr[s]);
			return;
		}
		int m = (s + e) >> 1;
		build(idx << 1, s, m);
		build((idx << 1) + 1, m + 1, e);
		tree.get(idx).addAll(tree.get(idx << 1));
		tree.get(idx).addAll(tree.get((idx << 1) + 1));
	}

	private static int query(int idx, int s, int e, int l, int r, int val) {
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return upperBound(tree.get(idx), val);
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r, val) + query((idx << 1) + 1, m + 1, e, l, r, val);
	}

	private static int upperBound(ArrayList<Integer> al, int val) {
		int l = 0, r = al.size() - 1;
		while (l <= r) {
			int m = (l + r) >> 1;
			if (al.get(m) <= val)
				l = m + 1;
			else
				r = m - 1;
		}
		return al.size() - l;
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