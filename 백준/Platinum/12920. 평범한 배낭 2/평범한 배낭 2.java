public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; i++) {
			int v = read(), c = read(), k = read();
			for (int j = k; j > 0; j >>= 1) {
				int cnt = j - (j >> 1);
				for (int l = m; l >= v * cnt; l--)
					dp[l] = Math.max(dp[l], dp[l - (v * cnt)] + cnt * c);
			}
		}
		System.out.println(dp[m]);
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