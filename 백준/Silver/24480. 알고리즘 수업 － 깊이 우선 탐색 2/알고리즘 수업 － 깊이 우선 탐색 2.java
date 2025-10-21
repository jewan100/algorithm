import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	static ArrayList<PriorityQueue<Integer>> al = new ArrayList<>();
	static int[] visited;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read(), r = read();
		visited = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			al.add(new PriorityQueue<>((o1, o2) -> o2 - o1));
		for (int i = 0; i < m; i++) {
			int u = read(), v = read();
			al.get(u).add(v);
			al.get(v).add(u);
		}
		dfs(r);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++)
			sb.append(visited[i]).append("\n");
		System.out.println(sb);
	}

	private static void dfs(int u) {
		visited[u] = ++cnt;
		PriorityQueue<Integer> pq = al.get(u);
		while (!pq.isEmpty()) {
			int v = pq.poll();
			if (visited[v] == 0)
				dfs(v);
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