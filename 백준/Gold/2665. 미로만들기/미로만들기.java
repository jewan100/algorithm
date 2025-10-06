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
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[3]);
		boolean[][] visited = new boolean[n][n];
		visited[0][0] = true;
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int y = cur[0], x = cur[1], cnt = cur[2];
			if (y == n - 1 && x == n - 1) {
				System.out.println(cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (isValid(ny, nx) && !visited[ny][nx]) {
					if (board[ny][nx])
						dq.offerFirst(new int[]{ny, nx, cnt});
					else
						dq.offerLast(new int[]{ny, nx, cnt + 1});
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}