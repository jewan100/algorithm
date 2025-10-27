import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> reGraph = new ArrayList<>();
	static boolean[] visited;
	static Deque<Integer> dq = new ArrayDeque<>();
	static ArrayList<PriorityQueue<Integer>> scc = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		int v = read(), e = read();
		for (int i = 0; i < v + 1; i++) {
			graph.add(new ArrayList<>());
			reGraph.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			int a = read(), b = read();
			graph.get(a).add(b);
			reGraph.get(b).add(a);
		}
		visited = new boolean[v + 1];
		for (int i = 1; i < v + 1; i++)
			if (!visited[i])
				dfs(i);
		visited = new boolean[v + 1];
		int num = 0;
		while (!dq.isEmpty()) {
			int cur = dq.pollLast();
			if (!visited[cur]) {
				scc.add(new PriorityQueue<>());
				reDfs(cur, num);
				num++;
			}
		}
		scc.sort((o1, o2) -> o1.peek() - o2.peek());
		StringBuilder sb = new StringBuilder();
		sb.append(scc.size()).append("\n");
		for (PriorityQueue<Integer> pq : scc) {
			while (!pq.isEmpty())
				sb.append(pq.poll()).append(" ");
			sb.append("-1\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		for (int next : graph.get(cur))
			if (!visited[next])
				dfs(next);
		dq.offerLast(cur);
	}

	private static void reDfs(int cur, int num) {
		visited[cur] = true;
		scc.get(num).add(cur);
		for (int next : reGraph.get(cur))
			if (!visited[next])
				reDfs(next, num);
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
