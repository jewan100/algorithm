import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
	static char[][] board;
	static int maxDepth = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];
		for (int i = 0; i < 12; i++)
			board[i] = br.readLine().toCharArray();
		bfs(0);
		System.out.println(maxDepth);
	}

	private static void bfs(int depth) {
		maxDepth = Math.max(maxDepth, depth);
		ArrayList<ArrayList<int[]>> al = new ArrayList<>();
		boolean[][] visited = new boolean[12][6];
		for (int i = 0; i < 12; i++)
			for (int j = 0; j < 6; j++) {
				if (board[i][j] != '.' && !visited[i][j]) {
					Deque<int[]> dq = new ArrayDeque<>();
					ArrayList<int[]> temp = new ArrayList<>();
					char c = board[i][j];
					dq.offer(new int[]{i, j});
					temp.add(new int[]{i, j});
					visited[i][j] = true;
					while (!dq.isEmpty()) {
						int[] cur = dq.poll();
						int y = cur[0], x = cur[1];
						for (int k = 0; k < 4; k++) {
							int ny = y + dy[k], nx = x + dx[k];
							if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] == c) {
								dq.offer(new int[]{ny, nx});
								temp.add(new int[]{ny, nx});
								visited[ny][nx] = true;
							}
						}
					}
					if (temp.size() >= 4)
						al.add(temp);
				}

			}
		if (!al.isEmpty()) {
			for (int i = 0; i < al.size(); i++)
				for (int[] pos : al.get(i))
					board[pos[0]][pos[1]] = '.';
			down();
			bfs(depth + 1);
		}
	}

	private static void down() {
		for (int i = 0; i < 6; i++)
			for (int j = 10; j >= 0; j--)
				if (board[j][i] != '.') {
					int p = j;
					while (p + 1 < 12 && board[p + 1][i] == '.')
						p++;
					swap(i, j, p);
				}
	}

	private static void swap(int a, int b, int c) {
		char temp = board[c][a];
		board[c][a] = board[b][a];
		board[b][a] = temp;
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < 12 && 0 <= x && x < 6;
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