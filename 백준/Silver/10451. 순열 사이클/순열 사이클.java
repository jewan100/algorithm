public class Main {

	static int n;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		int t = read();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			n = read();
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = read() - 1;
			visited = new boolean[n];
			int cnt = 0;
			for (int i = 0; i < n; i++)
				if (!visited[i]) {
					cnt++;
					visited[i] = true;
					recursive(arr[i]);
				}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void recursive(int p) {
		if (!visited[p]) {
			visited[p] = true;
			recursive(arr[p]);
		}
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