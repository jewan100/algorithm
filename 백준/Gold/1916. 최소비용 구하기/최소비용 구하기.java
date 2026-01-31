import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = Integer.MAX_VALUE >> 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()),
					w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new int[]{v, w});
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
		int[] dist = new int[n + 1];
		Arrays.fill(dist, MAX);
		dist[s] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
		boolean[] visited = new boolean[n + 1];
		pq.offer(s);
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			if (visited[cur])
				continue;
			visited[cur] = true;
			for (int[] next : graph.get(cur)) {
				if (dist[next[0]] > dist[cur] + next[1]) {
					dist[next[0]] = dist[cur] + next[1];
					pq.offer(next[0]);
				}
			}
		}
		System.out.println(dist[e]);
	}
}