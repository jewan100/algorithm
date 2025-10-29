import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> r = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> s = new ArrayList<>();
	static Deque<Integer> dq = new ArrayDeque<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			g.add(new ArrayList<>());
			r.add(new ArrayList<>());
			s.add(new ArrayList<>());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++)
				if (line.charAt(j) == '1') {
					g.get(i).add(j);
					r.get(j).add(i);
				}
		}
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			if (!visited[i])
				dfs(i);
		visited = new boolean[n];
		int num = 0;
		while (!dq.isEmpty()) {
			int cur = dq.pollLast();
			if (!visited[cur]) {
				reDfs(cur, num);
				num++;
			}
		}
		int minSum = 0;
		for (int i = 0; i < num; i++) {
			s.get(i).sort((o1, o2) -> arr[o1] - arr[o2]);
			minSum += arr[s.get(i).get(0)];
		}
		System.out.println(minSum);
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
