public class Main {

	public static void main(String[] args) throws Exception {
		int t = read();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = read();
			int[] sum = new int[n + 1];
			int[][] dp = new int[n + 1][n + 1];
			for (int i = 1; i < n + 1; i++)
				sum[i] = sum[i - 1] + read();
			for (int k = 1; k < n + 1; k++)
				for (int i = 1; i + k < n + 1; i++) {
					int j = i + k;
					dp[i][j] = Integer.MAX_VALUE;
					for (int m = i; m < j; m++)
						dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j] + (sum[j] - sum[i - 1]));
				}
			sb.append(dp[1][n]).append("\n");
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