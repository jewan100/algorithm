import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read(), r = read();
		ArrayList<PriorityQueue<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			al.add(new PriorityQueue<>());
		for (int i = 0; i < m; i++) {
			int u = read(), v = read();
			al.get(u).add(v);
			al.get(v).add(u);
		}
		Deque<Integer> dq = new ArrayDeque<>();
		int[] visited = new int[n + 1];
		dq.offer(r);
		int cnt = 0;
		visited[r] = ++cnt;
		while (!dq.isEmpty()) {
			int u = dq.poll();
			while (!al.get(u).isEmpty()) {
				int v = al.get(u).poll();
				if (visited[v] == 0) {
					dq.offer(v);
					visited[v] = ++cnt;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++)
			sb.append(visited[i]).append("\n");
		System.out.println(sb);
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