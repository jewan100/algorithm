import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		int[] times = new int[n + 1];
		int[] indegree = new int[n + 1];
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			al.add(new ArrayList<>());
		for (int i = 1; i < n + 1; i++) {
			times[i] = read();
			int m = read();
			while (m-- > 0) {
				int v = read();
				indegree[i]++;
				al.get(v).add(i);
			}
		}
		int[] cost = new int[n + 1];
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i < n + 1; i++) {
			cost[i] = times[i];
			if (indegree[i] == 0)
				dq.offer(i);
		}
		while (!dq.isEmpty()) {
			int u = dq.poll();
			for (int v : al.get(u)) {
				cost[v] = Math.max(cost[v], cost[u] + times[v]);
				if (--indegree[v] == 0)
					dq.offer(v);
			}
		}
		int maxTime = 0;
		for (int i = 1; i < n + 1; i++)
			maxTime = Math.max(maxTime, cost[i]);
		System.out.println(maxTime);
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