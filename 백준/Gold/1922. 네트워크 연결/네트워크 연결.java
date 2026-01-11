import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	static int n, m;
	static ArrayList<ArrayList<int[]>> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		for (int i = 0; i < n + 1; i++)
			al.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int a = read(), b = read(), c = read();
			al.get(a).add(new int[]{b, c});
			al.get(b).add(new int[]{a, c});
		}
		int sum = 0, cnt = 0;
		boolean[] isMst = new boolean[n + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[]{1, 0});
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (isMst[cur[0]])
				continue;
			isMst[cur[0]] = true;
			cnt++;
			sum += cur[1];
			if (cnt == n)
				break;
			for (int[] next : al.get(cur[0])) {
				if (!isMst[next[0]])
					pq.offer(next);
			}
		}
		System.out.println(sum);
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