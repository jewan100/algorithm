import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	static ArrayList<ArrayList<Integer>> g;
	static ArrayList<ArrayList<Integer>> r;
	static ArrayList<ArrayList<Integer>> s;
	static Deque<Integer> dq;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		int t = read();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = read(), m = read();
			g = new ArrayList<>();
			r = new ArrayList<>();
			s = new ArrayList<>();
			dq = new ArrayDeque<>();
			for (int i = 0; i < n + 1; i++) {
				g.add(new ArrayList<>());
				r.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				int u = read(), v = read();
				g.get(u).add(v);
				r.get(v).add(u);
			}
			visited = new boolean[n + 1];
			for (int i = 1; i < n + 1; i++)
				if (!visited[i])
					dfs(i);
			visited = new boolean[n + 1];
			int num = 0;
			while (!dq.isEmpty()) {
				int cur = dq.pollLast();
				if (!visited[cur]) {
					s.add(new ArrayList<>());
					reDfs(cur, num);
					num++;
				}
			}
			int[] sArr = new int[n + 1];
			for (int i = 0; i < s.size(); i++)
				for (int cur : s.get(i))
					sArr[cur] = i;
			visited = new boolean[s.size()];
			for (int i = 1; i < n + 1; i++)
				for (int next : g.get(i))
					if (sArr[i] != sArr[next])
						visited[sArr[next]] = true;
			int cnt = 0;
			for (int i = 0; i < num; i++)
				if (!visited[i])
					cnt++;
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		for (int next : g.get(cur))
			if (!visited[next])
				dfs(next);
		dq.offerLast(cur);
	}

	private static void reDfs(int cur, int num) {
		visited[cur] = true;
		for (int next : r.get(cur))
			if (!visited[next])
				reDfs(next, num);
		s.get(num).add(cur);
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
