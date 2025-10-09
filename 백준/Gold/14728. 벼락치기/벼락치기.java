public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), t = read();
		int[] dp = new int[t + 1];
		for (int i = 0; i < n; i++) {
			int k = read(), s = read();
			for (int j = t; j >= k; j--)
				dp[j] = Math.max(dp[j], dp[j - k] + s);
		}
		System.out.println(dp[t]);
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