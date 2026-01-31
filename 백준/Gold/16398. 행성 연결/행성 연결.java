import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] adj = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++)
				adj[i][j] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		long minWeight = 0, cnt = 0;
		boolean[] isMST = new boolean[n + 1];
		pq.offer(new int[]{1, 0});
		while (cnt < n) {
			int[] edge = pq.poll();
			if (isMST[edge[0]])
				continue;
			isMST[edge[0]] = true;
			cnt++;
			minWeight += edge[1];
			for (int i = 1; i < n + 1; i++) {
				if (!isMST[i])
					pq.offer(new int[]{i, adj[edge[0]][i]});
			}
		}
		System.out.println(minWeight);
	}
}