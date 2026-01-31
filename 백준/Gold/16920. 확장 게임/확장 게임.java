import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, m, p;
	static int[] s, area;
	static int[][] board;
	static ArrayList<Deque<int[]>> al = new ArrayList<>();
	static ArrayList<Deque<int[]>> nextAl = new ArrayList<>();
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		s = new int[p + 1];
		area = new int[p + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < p + 1; i++)
			s[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < p + 1; i++) {
			al.add(new ArrayDeque<>());
			nextAl.add(new ArrayDeque<>());
		}
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] cArr = br.readLine().toCharArray();
			for (int j = 0; j < m; j++)
				if (cArr[j] == '#')
					board[i][j] = -1;
				else if (cArr[j] != '.')
					board[i][j] = cArr[j] - '0';
		}
		init();
		bfs();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < p + 1; i++)
			sb.append(area[i]).append(" ");
		System.out.println(sb);
	}

	private static void init() {
		for (int y = 0; y < n; y++)
			for (int x = 0; x < m; x++)
				if (board[y][x] > 0) {
					area[board[y][x]]++;
					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k], nx = x + dx[k];
						if (isValid(ny, nx) && board[ny][nx] == 0) {
							nextAl.get(board[y][x]).offer(new int[]{y, x});
							break;
						}
					}
				}
	}

	private static void bfs() {
		for (int i = 1; i <= p; i++) {
			al.get(i).addAll(nextAl.get(i));
			nextAl.get(i).clear();
		}
		boolean expanded = true;
		while (expanded) {
			expanded = false;
			for (int player = 1; player <= p; player++) {
				Deque<int[]> q = al.get(player);
				if (q.isEmpty())
					continue;
				for (int step = 0; step < s[player]; step++) {
					int size = q.size();
					if (size == 0)
						break;
					expanded = true;
					while (size-- > 0) {
						int[] cur = q.poll();
						int y = cur[0], x = cur[1];
						for (int dir = 0; dir < 4; dir++) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];
							if (!isValid(ny, nx))
								continue;
							if (board[ny][nx] != 0)
								continue;
							board[ny][nx] = player;
							area[player]++;
							q.offer(new int[]{ny, nx});
						}
					}
				}
			}
		}
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}
}