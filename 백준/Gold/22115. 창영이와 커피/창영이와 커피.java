import java.util.Arrays;

public class Main {

	static final int INF = Integer.MAX_VALUE >> 2;

	public static void main(String[] args) throws Exception {
		int n = read(), k = read();
		int[] dp = new int[k + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			int c = read();
			for (int j = k - c; j >= 0; j--)
				dp[j + c] = Math.min(dp[j + c], dp[j] + 1);
		}
		System.out.println(dp[k] == INF ? -1 : dp[k]);
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