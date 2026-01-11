import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static final int INF = Integer.MAX_VALUE >> 2;

	static int n, m, k;
	static ArrayList<ArrayList<int[]>> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		k = read();
		for (int i = 0; i < n + 1; i++)
			al.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int u = read(), v = read(), w = read();
			al.get(u).add(new int[]{v, w});
		}
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[k] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
		pq.offer(k);
		while (!pq.isEmpty()) {
			int u = pq.poll();
			for (int[] next : al.get(u)) {
				int v = next[0], w = next[1];
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					pq.add(v);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++)
			if (dist[i] == INF)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
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