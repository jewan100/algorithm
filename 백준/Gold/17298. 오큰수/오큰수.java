import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		int[] answer = new int[n];
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!dq.isEmpty() && dq.peek() <= arr[i])
				dq.poll();
			answer[i] = dq.isEmpty() ? -1 : dq.peek();
			dq.offerFirst(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i : answer)
			sb.append(i).append(" ");
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