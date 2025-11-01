import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

	static int[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		int n = read();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		tree = new long[n << 2];
		build(1, 0, n - 1);
		int m = read();
		Deque<int[]> dq = new ArrayDeque<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		for (int i = 0; i < m; i++) {
			int op = read();
			if (op == 1)
				dq.offer(new int[]{read() - 1, read()});
			else
				pq.offer(new int[]{pq.size(), read(), read() - 1, read() - 1});
		}
		long[] brr = new long[pq.size()];
		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] crr = pq.poll();
			int idx = crr[0], k = crr[1], l = crr[2], r = crr[3];
			while (cnt < k) {
				int[] drr = dq.poll();
				update(1, 0, n - 1, drr[0], drr[1]);
				cnt++;
			}
			brr[idx] = query(1, 0, n - 1, l, r);
		}
		StringBuilder sb = new StringBuilder();
		for (long i : brr)
			sb.append(i).append("\n");
		System.out.println(sb);
	}

	private static long build(int idx, int s, int e) {
		if (s == e) {
			tree[idx] = arr[s];
			return tree[idx];
		}
		int m = (s + e) >> 1;
		return tree[idx] = build(idx << 1, s, m) + build((idx << 1) + 1, m + 1, e);
	}

	private static long update(int idx, int s, int e, int pos, int val) {
		if (s == e) {
			tree[idx] = val;
			return tree[idx];
		}
		int m = (s + e) >> 1;
		if (pos <= m)
			return tree[idx] = update(idx << 1, s, m, pos, val) + tree[(idx << 1) + 1];
		return tree[idx] = tree[idx << 1] + update((idx << 1) + 1, m + 1, e, pos, val);
	}

	private static long query(int idx, int s, int e, int l, int r) {
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