public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j < n + 1; j++)
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + read();
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int x1 = read(), y1 = read(), x2 = read(), y2 = read();
			sb.append(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]).append("\n");
		}
		System.out.println(sb);
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