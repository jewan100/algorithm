public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), k = read();
		int[] dp = new int[n + 1];
		for (int i = 0; i < k; i++) {
			int I = read(), T = read();
			for (int j = n; j >= T; j--)
				dp[j] = Math.max(dp[j], dp[j - T] + I);
		}
		System.out.println(dp[n]);
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