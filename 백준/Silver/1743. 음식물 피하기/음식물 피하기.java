import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static int n, m;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		int k = read();
		boolean[][] board = new boolean[n][m];
		for (int i = 0; i < k; i++) {
			int r = read() - 1, c = read() - 1;
			board[r][c] = true;
		}
		int maxCnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (board[i][j]) {
					Deque<int[]> dq = new ArrayDeque<>();
					dq.offer(new int[]{i, j});
					board[i][j] = false;
					int cnt = 1;
					while (!dq.isEmpty()) {
						int[] cur = dq.poll();
						for (k = 0; k < 4; k++) {
							int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
							if (isValid(ny, nx) && board[ny][nx]) {
								dq.offer(new int[]{ny, nx});
								board[ny][nx] = false;
								cnt++;
							}
						}
					}
					maxCnt = Math.max(maxCnt, cnt);
				}
		System.out.println(maxCnt);
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