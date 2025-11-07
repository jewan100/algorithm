public class Main {

	static int n, size = 200_001;
	static int[] cntTree;
	static long[] valTree;
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		n = read();
		valTree = new long[size << 2];
		cntTree = new int[size << 2];
		update(1, 0, size, read());
		long answer = 1;
		for (int i = 1; i < n; i++) {
			int p = read();
			long l = ((long) p * cntQuery(1, 0, size, 0, p - 1)) - valQuery(1, 0, size, 0, p - 1);
			long r = valQuery(1, 0, size, p + 1, size) - ((long) p * cntQuery(1, 0, size, p + 1, size));
			long val = ((l % MOD) + (r % MOD)) % MOD;
			if (val < 0)
				val += MOD;
			answer = (answer * val) % MOD;
			update(1, 0, size, p);
		}
		if (answer < 0)
			answer += MOD;
		System.out.println(answer);
	}

	private static void update(int idx, int s, int e, int pos) {
		if (s == e) {
			valTree[idx] += s;
			cntTree[idx]++;
			return;
		}
		int m = (s + e) >> 1;
		if (pos <= m)
			update(idx << 1, s, m, pos);
		else
			update((idx << 1) + 1, m + 1, e, pos);
		valTree[idx] = valTree[idx << 1] + valTree[(idx << 1) + 1];
		cntTree[idx] = cntTree[idx << 1] + cntTree[(idx << 1) + 1];
	}

	private static long valQuery(int idx, int s, int e, int l, int r) {
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return valTree[idx];
		int m = (s + e) >> 1;
		return valQuery(idx << 1, s, m, l, r) + valQuery((idx << 1) + 1, m + 1, e, l, r);
	}

	private static int cntQuery(int idx, int s, int e, int l, int r) {
		if (r < s || e < l)
			return 0;
		if (l <= s && e <= r)
			return cntTree[idx];
		int m = (s + e) >> 1;
		return cntQuery(idx << 1, s, m, l, r) + cntQuery((idx << 1) + 1, m + 1, e, l, r);
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
