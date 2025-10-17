public class Main {

	static int n;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
	static int[][] board, dp;

	public static void main(String[] args) throws Exception {
		n = read();
		board = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = read();
		dp = new int[n][n];
		int maxCnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				maxCnt = Math.max(maxCnt, dfs(i, j));
		System.out.println(maxCnt);
	}

	private static int dfs(int y, int x) {
		if (dp[y][x] != 0)
			return dp[y][x];
		dp[y][x]++;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i], nx = x + dx[i];
			if (isValid(ny, nx) && board[y][x] < board[ny][nx])
				dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
		}
		return dp[y][x];
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
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