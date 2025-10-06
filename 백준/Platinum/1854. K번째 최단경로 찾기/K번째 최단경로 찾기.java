import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static final int INF = Integer.MAX_VALUE >> 2;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read(), k = read();
		ArrayList<PriorityQueue<Integer>> kthDist = new ArrayList<>();
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
			kthDist.add(new PriorityQueue<>((o1, o2) -> o2 - o1));
		}
		for (int i = 0; i < m; i++) {
			int a = read(), b = read(), c = read();
			graph.get(a).add(new int[]{b, c});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		pq.offer(new int[]{0, 1});
		kthDist.get(1).offer(0);
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curCost = cur[0];
			int u = cur[1];
			for (int[] edge : graph.get(u)) {
				int v = edge[0];
				int newCost = curCost + edge[1];
				PriorityQueue<Integer> distV = kthDist.get(v);
				if (distV.size() < k) {
					distV.offer(newCost);
					pq.offer(new int[]{newCost, v});
				} else if (distV.peek() > newCost) {
					distV.poll();
					distV.offer(newCost);
					pq.offer(new int[]{newCost, v});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			if (kthDist.get(i).size() < k)
				sb.append(-1);
			else
				sb.append(kthDist.get(i).poll());
			sb.append("\n");
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