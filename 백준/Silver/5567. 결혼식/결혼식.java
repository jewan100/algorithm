import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			al.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int a = read(), b = read();
			al.get(a).add(b);
			al.get(b).add(a);
		}

		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		dq.offer(1);
		visited[1] = true;
		int cnt = 0;
		int t = 2;
		while (t-- > 0) {
			int size = dq.size();
			while (size-- > 0) {
				int u = dq.poll();
				for (int v : al.get(u))
					if (!visited[v]) {
						dq.offer(v);
						visited[v] = true;
						cnt++;
					}
			}
		}
		System.out.println(cnt);
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