import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] dy = { 0, 0, 1 };
	static int[] dx = { -1, 1, 0 };
	static int[] ly = { 1, 1 };
	static int[] lx = { -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		char[][] board = new char[n][n];
		int hy = 0, hx = 0;
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '*' && (hy == 0 && hx == 0)) {
					hy = i + 1;
					hx = j;
				}
			}
		}
		sb.append(hy + 1).append(" ").append(hx + 1).append("\n");
		for (int i = 0; i < 3; i++) {
			int len = 0;
			while (isValid(hy + (dy[i] * len), hx + (dx[i] * len))
					&& board[hy + (dy[i] * len)][hx + (dx[i] * len)] == '*')
				len++;
			sb.append(len - 1).append(" ");
			if (i == 2) {
				for (int j = 0; j < 2; j++) {
					int lLen = 0;
					while (isValid(hy + (ly[j] * lLen) + (dy[i] * len), hx + lx[j] + (dx[i] * len))
							&& board[hy + (ly[j] * lLen) + (dy[i] * len)][hx + lx[j] + (dx[i] * len)] == '*')
						lLen++;
					sb.append(lLen).append(" ");
				}
			}
		}
		System.out.println(sb);
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}