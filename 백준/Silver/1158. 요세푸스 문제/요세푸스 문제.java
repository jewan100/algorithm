import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder("<");
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i < n + 1; i++)
			dq.offer(i);
		while (!dq.isEmpty()) {
			for (int i = 0; i < k - 1; i++)
				dq.offer(dq.poll());
			sb.append(dq.poll());
			if (!dq.isEmpty())
				sb.append(", ");
		}
		System.out.println(sb.append(">"));
	}
}