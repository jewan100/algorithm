import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static int w, h;
	static boolean[][] board;
	static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0}, dx = {1, 0, -1, -1, -1, 0, 1, 1, 1};

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		while (true) {
			w = read();
			h = read();
			if (w == 0 && h == 0)
				break;
			board = new boolean[h][w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					board[i][j] = read() == 1;
			sb.append(calculate());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int calculate() {
		int cnt = 0;
		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if (board[i][j]) {
					cnt++;
					board[i][j] = false;
					dq.offer(new int[]{i, j});
					while (!dq.isEmpty()) {
						int[] cur = dq.poll();
						int y = cur[0], x = cur[1];
						for (int k = 0; k < 8; k++) {
							int ny = y + dy[k], nx = x + dx[k];
							if (isValid(ny, nx) && board[ny][nx]) {
								dq.offer(new int[]{ny, nx});
								board[ny][nx] = false;
							}
						}
					}
				}
		return cnt;
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < h && 0 <= x && x < w;
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
