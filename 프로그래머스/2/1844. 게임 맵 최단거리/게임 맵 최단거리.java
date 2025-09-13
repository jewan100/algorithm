import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    static int n, m;
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        n = maps.length;
		m = maps[0].length;
		boolean[][] visited = new boolean[n][m];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[]{0, 0, 1});
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int y = now[0], x = now[1], t = now[2];
			if (y == n - 1 && x == m - 1)
				return t;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (isValid(ny, nx) && maps[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dq.offer(new int[]{ny, nx, t + 1});
				}
			}
		}
		return -1;
    }
	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}
}