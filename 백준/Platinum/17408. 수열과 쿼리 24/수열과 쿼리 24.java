import java.util.Arrays;

public class Main {

	static class Node {
		int m1, m2;
		Node(int m1, int m2) {
			this.m1 = m1;
			this.m2 = m2;
		}
	}

	static int[] arr;
	static Node[] tree;

	public static void main(String[] args) throws Exception {
		int n = read();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		tree = new Node[n << 2];
		build(1, 0, n - 1);
		int m = read();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int op = read(), a = read(), b = read();
			if (op == 1)
				update(1, 0, n - 1, a - 1, b);
			else {
				Node r = query(1, 0, n - 1, a - 1, b - 1);
				sb.append(r.m1 + r.m2).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static Node merge(Node n1, Node n2) {
		int[] arr = {n1.m1, n1.m2, n2.m1, n2.m2};
		Arrays.sort(arr);
		return new Node(arr[3], arr[2]);
	}

	private static Node build(int idx, int s, int e) {
		if (s == e)
			return tree[idx] = new Node(arr[s], 0);
		int m = (s + e) >> 1;
		return tree[idx] = merge(build(idx << 1, s, m), build((idx << 1) + 1, m + 1, e));
	}

	private static Node update(int idx, int s, int e, int pos, int val) {
		if (s == e)
			return tree[idx] = new Node(val, 0);
		int m = (s + e) >> 1;
		if (pos <= m)
			return tree[idx] = merge(update(idx << 1, s, m, pos, val), tree[(idx << 1) + 1]);
		return tree[idx] = merge(tree[idx << 1], update((idx << 1) + 1, m + 1, e, pos, val));
	}

	private static Node query(int idx, int s, int e, int l, int r) {
		if (r < s || e < l)
			return new Node(0, 0);
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return merge(query(idx << 1, s, m, l, r), query((idx << 1) + 1, m + 1, e, l, r));
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