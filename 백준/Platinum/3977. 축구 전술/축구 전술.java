import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> g;
	static ArrayList<ArrayList<Integer>> r;
	static ArrayList<ArrayList<Integer>> s;
	static Deque<Integer> dq;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		loop : while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			g = new ArrayList<>();
			r = new ArrayList<>();
			s = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				g.add(new ArrayList<>());
				r.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				g.get(u).add(v);
				r.get(v).add(u);
			}
			br.readLine();
			dq = new ArrayDeque<>();
			v = new boolean[n];
			for (int i = 0; i < n; i++)
				if (!v[i])
					dfs(i, true);
			v = new boolean[n];
			while (!dq.isEmpty()) {
				int cur = dq.pollLast();
				if (!v[cur]) {
					s.add(new ArrayList<>());
					dfs(cur, false);
				}
			}
			int[] sArr = new int[n];
			for (int i = 0; i < s.size(); i++)
				for (int j : s.get(i))
					sArr[j] = i;
			int[] indeg = new int[s.size()];
			for (int i = 0; i < n; i++)
				for (int j : g.get(i))
					if (sArr[i] != sArr[j])
						indeg[sArr[j]]++;
			int zeroCnt = 0;
			int target = -1;
			for (int i = 0; i < s.size(); i++) {
				if (indeg[i] == 0) {
					zeroCnt++;
					target = i;
					if (zeroCnt > 1)
						break;
				}
			}
			if (zeroCnt != 1) {
				sb.append("Confused\n\n");
				continue loop;
			}

			s.get(target).sort((o1, o2) -> o1 - o2);
			for (int i : s.get(target))
				sb.append(i).append("\n");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur, boolean f) {
		v[cur] = true;
		ArrayList<Integer> edge = f ? g.get(cur) : r.get(cur);
		for (int next : edge)
			if (!v[next])
				dfs(next, f);
		if (f)
			dq.offerLast(cur);
		else
			s.get(s.size() - 1).add(cur);
	}
}