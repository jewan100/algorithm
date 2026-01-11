public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[] arr = new int[n];
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = read();
			dp[i + 1] = dp[i] + arr[i];
		}
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int i = read(), j = read();
			sb.append(dp[j] - dp[i - 1]).append("\n");
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