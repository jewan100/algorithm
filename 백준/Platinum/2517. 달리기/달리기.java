import java.util.Arrays;
import java.util.HashMap;

public class Main {

	static int n;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		n = read();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		int[] brr = arr.clone();
		Arrays.sort(brr);
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++)
			hm.put(brr[i], i);
		tree = new int[n << 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(i - query(1, 0, n - 1, 0, hm.get(arr[i])) + 1).append("\n");
			update(1, 0, n - 1, hm.get(arr[i]));
		}
		System.out.println(sb);
	}

	private static int update(int idx, int s, int e, int pos) {
		if (s == e)
			return ++tree[idx];
		int m = (s + e) >> 1;
		if (pos <= m)
			return tree[idx] = update(idx << 1, s, m, pos) + tree[(idx << 1) + 1];
		return tree[idx] = tree[idx << 1] + update((idx << 1) + 1, m + 1, e, pos);
	}

	private static int query(int idx, int s, int e, int l, int r) {
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r) + query((idx << 1) + 1, m + 1, e, l, r);
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
