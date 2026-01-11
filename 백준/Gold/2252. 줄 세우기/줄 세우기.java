import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[] indegree = new int[n + 1];
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			al.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int u = read(), v = read();
			indegree[v]++;
			al.get(u).add(v);
		}
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i < n + 1; i++)
			if (indegree[i] == 0)
				dq.offer(i);
		while (!dq.isEmpty()) {
			int u = dq.poll();
			sb.append(u).append(" ");
			for (int v : al.get(u))
				if (--indegree[v] == 0)
					dq.offer(v);
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