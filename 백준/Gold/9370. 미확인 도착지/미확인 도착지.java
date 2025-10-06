import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	static final long INF = Long.MAX_VALUE / 4;

	public static void main(String[] args) throws Exception {
		int T = read();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = read(), m = read(), t = read();
			int s = read(), g = read(), h = read();
			ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
			for (int i = 0; i < n + 1; i++)
				graph.add(new ArrayList<>());

			int ghWeight = 0;

			for (int i = 0; i < m; i++) {
				int u = read(), v = read(), w = read();

				if ((u == g && v == h) || (u == h && v == g))
					ghWeight = w;

				graph.get(u).add(new int[]{v, w});
				graph.get(v).add(new int[]{u, w});
			}

			long[] distS = dijkstra(n, s, graph);
			long[] distG = dijkstra(n, g, graph);
			long[] distH = dijkstra(n, h, graph);

			ArrayList<Integer> answer = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				int x = read();
				if (distS[x] == INF)
					continue;
				long path1 = (distS[g] != INF && distH[x] != INF) ? distS[g] + ghWeight + distH[x] : INF;
				long path2 = (distS[h] != INF && distG[x] != INF) ? distS[h] + ghWeight + distG[x] : INF;

				long bestViaGH = Math.min(path1, path2);

				if (bestViaGH == distS[x]) {
					answer.add(x);
				}
			}
			answer.sort(Integer::compareTo);
			for (int i : answer)
				sb.append(i).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static long[] dijkstra(int n, int s, ArrayList<ArrayList<int[]>> graph) {
		long[] dist = new long[n + 1];
		Arrays.fill(dist, Long.MAX_VALUE / 4);
		dist[s] = 0;

		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
		pq.offer(new long[]{0, s});

		boolean[] visited = new boolean[n + 1];
		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			long d = cur[0];
			int u = (int) cur[1];
			if (visited[u])
				continue;
			visited[u] = true;
			for (int[] edge : graph.get(u)) {
				int v = edge[0];
				int w = edge[1];
				if (!visited[v] && dist[v] > d + w) {
					dist[v] = d + w;
					pq.offer(new long[]{dist[v], v});
				}
			}
		}
		return dist;
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