import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boolean[][] board = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] cArr = br.readLine().toCharArray();
			for (int j = 0; j < m; j++)
				board[i][j] = cArr[j] == '1';
		}
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[]{0, 0, 1});
		board[0][0] = false;
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int y = cur[0], x = cur[1], t = cur[2];
			if (y == n - 1 && x == m - 1) {
				System.out.println(t);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (isValid(ny, nx) && board[ny][nx]) {
					board[ny][nx] = false;
					dq.offer(new int[]{ny, nx, t + 1});
				}
			}
		}
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