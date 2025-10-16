public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[][] profit = new int[m + 1][n + 1];
		for (int money = 1; money <= n; money++) {
			read();
			for (int company = 1; company <= m; company++)
				profit[company][money] = read();
		}
		int[] dp = new int[n + 1];
		int[][] path = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = n; j >= 0; j--)
				for (int k = 0; k <= j; k++) {
					int val = dp[j - k] + profit[i][k];
					if (val > dp[j]) {
						dp[j] = val;
						path[i][j] = k;
					}
				}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[n]).append("\n");
		int[] invest = new int[m + 1];
		int remain = n;
		for (int i = m; i >= 1; i--) {
			invest[i] = path[i][remain];
			remain -= invest[i];
		}
		for (int i = 1; i <= m; i++)
			sb.append(invest[i]).append(" ");
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