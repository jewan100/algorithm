import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = read();
		while (t-- > 0) {
			int n = read(), d = read(), c = read();
			ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
			for (int i = 0; i < n + 1; i++)
				graph.add(new ArrayList<>());
			for (int i = 0; i < d; i++) {
				int a = read(), b = read(), s = read();
				graph.get(b).add(new int[]{a, s});
			}
			
			int[] dist = new int[n + 1];
			Arrays.fill(dist, INF);
			dist[c] = 0;
			
			PriorityQueue<Integer> dq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
			dq.offer(c);

			boolean[] visited = new boolean[n + 1];
			int cnt = 0;
			while (!dq.isEmpty()) {
				int u = dq.poll();
				if (visited[u])
					continue;
				cnt++;
				visited[u] = true;
				for (int[] edge : graph.get(u)) {
					int v = edge[0], w = edge[1];
					if (!visited[v] && dist[v] > dist[u] + w) {
						dist[v] = dist[u] + w;
						dq.offer(v);
					}
				}
			}
			int maxWeight = 0;
			for (int w : dist) {
				if (w == INF)
					continue;
				maxWeight = Math.max(maxWeight, w);
			}
			sb.append(cnt).append(" ").append(maxWeight).append("\n");
		}
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