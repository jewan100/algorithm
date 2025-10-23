import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		int s = read();
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[2001][2001];
		dq.offer(new int[] { 0, 1, 0 });
		visited[1][0] = true;
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int time = cur[0], cnt = cur[1], clip = cur[2];
			if (cnt == s) {
				System.out.println(time);
				return;
			}
			if (!visited[cnt][cnt]) {
				visited[cnt][cnt] = true;
				dq.offer(new int[] { time + 1, cnt, cnt });
			}
			if (clip > 0 && cnt + clip < 2001 && !visited[cnt + clip][clip]) {
				visited[cnt + clip][clip] = true;
				dq.offer(new int[] { time + 1, cnt + clip, clip });
			}
			if (cnt > 0 && !visited[cnt - 1][clip]) {
				visited[cnt - 1][clip] = true;
				dq.offer(new int[] { time + 1, cnt - 1, clip });
			}
		}
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