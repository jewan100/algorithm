import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
	static boolean[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] cArr = br.readLine().toCharArray();
			for (int j = 0; j < m; j++)
				board[i][j] = cArr[j] == '0';
		}
		boolean[][][] visited = new boolean[k + 1][n][m];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[]{0, 0, 0, 1});
		visited[0][0][0] = true;
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int y = cur[0], x = cur[1];
			if (y == n - 1 && x == m - 1) {
				System.out.println(cur[3]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (isValid(ny, nx) && !visited[cur[2]][ny][nx]) {
					if (board[ny][nx]) {
						dq.offer(new int[]{ny, nx, cur[2], cur[3] + 1});
						visited[cur[2]][ny][nx] = true;
					} else if (cur[2] < k) {
						dq.offer(new int[]{ny, nx, cur[2] + 1, cur[3] + 1});
						visited[cur[2] + 1][ny][nx] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}
}