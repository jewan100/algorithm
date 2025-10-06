import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static int n;
	static boolean[][] board;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++)
				board[i][j] = line.charAt(j) == '1';
		}
		int cnt = 0;
		while (cnt <= Math.pow(n, 2)) {
			if (bfs(cnt))
				break;
			cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean bfs(int cnt) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[]{0, 0, cnt});
		boolean[][][] visited = new boolean[cnt + 1][n][n];
		visited[cnt][0][0] = true;
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int y = cur[0], x = cur[1], t = cur[2];
			if (y == n - 1 && x == n - 1)
				return true;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (isValid(ny, nx)) {
					if (board[ny][nx] && !visited[t][ny][nx]) {
						dq.offer(new int[]{ny, nx, t});
						visited[t][ny][nx] = true;
					}
					if (!board[ny][nx] && t > 0 && !visited[t - 1][ny][nx]) {
						dq.offer(new int[]{ny, nx, t - 1});
						visited[t - 1][ny][nx] = true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}