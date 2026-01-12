public class Main {

	static int n, k;

	public static void main(String[] args) throws Exception {
		n = read();
		k = read();
		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			int w = read(), v = read();
			for (int j = k - w; j >= 0; j--)
				dp[j + w] = Math.max(dp[j + w], dp[j] + v);
		}
		System.out.println(dp[k]);
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