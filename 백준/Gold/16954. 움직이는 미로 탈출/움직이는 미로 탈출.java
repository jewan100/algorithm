import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static boolean[][][] board = new boolean[9][8][8];
	static boolean[][][] visited = new boolean[9][8][8];
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1, 0}, dx = {0, -1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++)
				if (line.charAt(j) == '#')
					board[0][i][j] = true;
		}
		for (int k = 1; k < 9; k++)
			for (int i = 1; i < 8; i++)
				for (int j = 0; j < 8; j++) {
					board[k][i][j] = board[k - 1][i - 1][j];
				}

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[]{0, 7, 0});
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int t = cur[0], y = cur[1], x = cur[2];
			if (y == 0 && x == 7) {
				System.out.println(1);
				return;
			}
			if (board[t][y][x])
				continue;
			for (int i = 0; i < 9; i++) {
				int ny = y + dy[i], nx = x + dx[i], nt = t < 8 ? t + 1 : t;
				if (isValid(ny, nx) && !board[t][ny][nx] && !visited[nt][ny][nx]) {
					visited[nt][ny][nx] = true;
					dq.offer(new int[]{nt, ny, nx});
				}
			}
		}
		System.out.println(0);
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < 8 && 0 <= x && x < 8;
	}
}
