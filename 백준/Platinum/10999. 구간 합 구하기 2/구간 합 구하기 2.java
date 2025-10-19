import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] arr;
	static long tree[], lazy[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
				k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		tree = new long[n << 2];
		lazy = new long[n << 2];
		for (int i = 0; i < n; i++)
			arr[i] = Long.parseLong(br.readLine());
		build(1, 0, n - 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			int l = Math.min(a, b) - 1, r = Math.max(a, b) - 1;
			if (op == 1) {
				long c = Long.parseLong(st.nextToken());
				update(1, 0, n - 1, l, r, c);
			} else
				sb.append(query(1, 0, n - 1, l, r)).append("\n");
		}
		System.out.println(sb);
	}

	private static long build(int idx, int s, int e) {
		if (s == e)
			return tree[idx] = arr[s];
		int m = (s + e) >> 1;
		return tree[idx] = build(idx << 1, s, m) + build((idx << 1) + 1, m + 1, e);
	}

	private static long update(int idx, int s, int e, int l, int r, long val) {
		if (lazy[idx] != 0) {
			apply(idx, s, e, lazy[idx]);
			lazy[idx] = 0;
		}
		if (r < s || e < l)
			return tree[idx];
		if (l <= s && e <= r) {
			apply(idx, s, e, val);
			return tree[idx];
		}
		int m = (s + e) >> 1;
		return tree[idx] = update(idx << 1, s, m, l, r, val) + update((idx << 1) + 1, m + 1, e, l, r, val);
	}

	private static long query(int idx, int s, int e, int l, int r) {
		if (lazy[idx] != 0) {
			apply(idx, s, e, lazy[idx]);
			lazy[idx] = 0;
		}
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query(idx << 1, s, m, l, r) + query((idx << 1) + 1, m + 1, e, l, r);
	}

	private static void apply(int idx, int s, int e, long val) {
		tree[idx] += (e - s + 1) * val;
		if (s != e) {
			lazy[idx << 1] += val;
			lazy[(idx << 1) + 1] += val;
		}
	}
}