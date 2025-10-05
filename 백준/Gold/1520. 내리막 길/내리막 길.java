public class Main {
	static int n, m;
	static int[][] board, dp;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		board = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				board[i][j] = read();
		dp[n - 1][m - 1] = 1;
		recursive(0, 0);
		System.out.println(dp[0][0]);
	}

	private static int recursive(int y, int x) {
		if (dp[y][x] != 0)
			return dp[y][x];
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i], nx = x + dx[i];
			if (isValid(ny, nx) && board[y][x] > board[ny][nx] && dp[ny][nx] != -1) {
				int cnt = recursive(ny, nx);
				if (cnt == 0)
					dp[ny][nx] = -1;
				else
					dp[y][x] += cnt;
			}
		}
		return dp[y][x];
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
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