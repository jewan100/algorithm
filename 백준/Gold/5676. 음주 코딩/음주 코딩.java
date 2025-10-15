import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr, tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
			arr = new int[n];
			tree = new int[n << 2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			build(1, 0, n - 1);
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				String oper = st.nextToken();
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				if (oper.equals("C"))
					update(1, 0, n - 1, a - 1, b);
				else {
					switch (query(1, 0, n - 1, a - 1, b - 1)) {
						case 0 :
							sb.append("0");
							break;
						case 1 :
							sb.append("+");
							break;
						case -1 :
							sb.append("-");
							break;
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int build(int idx, int s, int e) {
		if (s == e)
			return tree[idx] = arr[s] == 0 ? 0 : arr[s] > 0 ? 1 : -1;
		int m = (s + e) >> 1;
		return tree[idx] = build(idx << 1, s, m) * build((idx << 1) + 1, m + 1, e);
	}

	private static void update(int idx, int s, int e, int pos, int val) {
		if (s == e) {
			tree[idx] = val == 0 ? 0 : val > 0 ? 1 : -1;
			return;
		}
		int m = (s + e) >> 1;
		if (pos <= m)
			update(idx << 1, s, m, pos, val);
		else
			update((idx << 1) + 1, m + 1, e, pos, val);
		tree[idx] = tree[idx << 1] * tree[(idx << 1) + 1];
	}

	private static int query(int idx, int s, int e, int l, int r) {
		if (l > e || r < s)
			return 1;
		if (l <= s && e <= r)
			return tree[idx];
		int m = (s + e) >> 1;
		return query((idx << 1), s, m, l, r) * query((idx << 1) + 1, m + 1, e, l, r);
	}
}