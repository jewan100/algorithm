import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		ArrayList<ArrayList<int[]>> natural = new ArrayList<>();
		ArrayList<ArrayList<int[]>> reversal = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			natural.add(new ArrayList<>());
			reversal.add(new ArrayList<>());
		}
		int[] indegree = new int[n + 1];
		while (m-- > 0) {
			int u = read(), v = read(), w = read();
			indegree[v]++;
			natural.get(u).add(new int[]{v, w});
			reversal.get(v).add(new int[]{u, w});
		}
		int s = read(), e = read();
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(s);
		int[] maxTimes = new int[n + 1];
		int maxTime = 0;
		while (!dq.isEmpty()) {
			int u = dq.poll();
			for (int[] edge : natural.get(u)) {
				int v = edge[0], w = edge[1];
				maxTimes[v] = Math.max(maxTimes[v], maxTimes[u] + w);
				maxTime = Math.max(maxTime, maxTimes[v]);
				if (--indegree[v] == 0)
					dq.offer(v);
			}
		}
		dq.offer(e);
		int cnt = 0;
		boolean[] visited = new boolean[n + 1];
		while (!dq.isEmpty()) {
			int u = dq.poll();
			if (u == s)
				continue;
			for (int[] edge : reversal.get(u)) {
				int v = edge[0], w = edge[1];
				if (maxTimes[v] + w == maxTimes[u]) {
					cnt++;
					if (!visited[v]) {
						dq.offer(v);
						visited[v] = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(maxTime).append("\n").append(cnt);
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