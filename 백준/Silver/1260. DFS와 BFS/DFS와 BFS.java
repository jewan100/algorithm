import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	static int n, m, v;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		v = read();
		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int u = read(), v = read();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for (int i = 1; i < n + 1; i++)
			graph.get(i).sort((o1, o2) -> o1 - o2);
		dfs(v, new boolean[n + 1]);
		sb.append("\n");
		bfs(v, new boolean[n + 1]);
		System.out.println(sb);
	}

	private static void dfs(int u, boolean[] visited) {
		sb.append(u).append(" ");
		visited[u] = true;
		for (int v : graph.get(u))
			if (!visited[v])
				dfs(v, visited);
	}

	private static void bfs(int u, boolean[] visited) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(u);
		visited[u] = true;
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			sb.append(cur).append(" ");
			for (int v : graph.get(cur)) {
				if (!visited[v]) {
					dq.offer(v);
					visited[v] = true;
				}
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