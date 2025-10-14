import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int r, c;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
	static int[][] swan = new int[2][2];
	static int[][] board;
	static Deque<int[]> swanDq = new ArrayDeque<>();
	static Deque<int[]> waterDq = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		int idx = 0;
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				char c = line.charAt(j);
				if (c == 'X')
					board[i][j] = -1;
				else {
					waterDq.add(new int[]{i, j});
					if (c == 'L')
						swan[idx++] = new int[]{i, j};
				}

			}
		}
		swanDq.offer(swan[0]);
		board[swan[0][0]][swan[0][1]] = 1;
		int time = 0;
		while (!move()) {
			melt();
			time++;
		}
		System.out.println(time);
	}

	private static boolean move() {
		Deque<int[]> nextDq = new ArrayDeque<>();
		while (!swanDq.isEmpty()) {
			int[] cur = swanDq.poll();
			int y = cur[0], x = cur[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (ny == swan[1][0] && nx == swan[1][1])
					return true;
				if (isValid(ny, nx) && board[ny][nx] != 1) {
					if (board[ny][nx] == 0)
						swanDq.offer(new int[]{ny, nx});
					else
						nextDq.offer(new int[]{ny, nx});
					board[ny][nx] = 1;
				}
			}
		}
		swanDq = nextDq;
		return false;
	}

	private static void melt() {
		Deque<int[]> nextDq = new ArrayDeque<>();
		while (!waterDq.isEmpty()) {
			int[] cur = waterDq.poll();
			int y = cur[0], x = cur[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (isValid(ny, nx) && board[ny][nx] == -1) {
					nextDq.offer(new int[]{ny, nx});
					board[ny][nx] = 0;
				}
			}
		}
		waterDq = nextDq;
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < r && 0 <= x && x < c;
	}
}