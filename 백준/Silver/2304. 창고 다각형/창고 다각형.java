import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		int n = read();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++)
			arr[i] = new int[] { read(), read() };
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		Deque<int[]> lDq = new ArrayDeque<>();
		Deque<int[]> rDq = new ArrayDeque<>();
		int totalArea = 0;
		for (int i = 0; i < n; i++) {
			if (lDq.isEmpty()) {
				lDq.push(arr[i]);
				continue;
			}
			if (lDq.peek()[1] < arr[i][1]) {
				int[] prev = lDq.poll();
				totalArea += Math.abs(arr[i][0] - prev[0]) * prev[1];
				lDq.push(arr[i]);
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (rDq.isEmpty()) {
				rDq.push(arr[i]);
				continue;
			}
			if (rDq.peek()[1] < arr[i][1]) {
				int[] prev = rDq.poll();
				totalArea += Math.abs(arr[i][0] - prev[0]) * prev[1];
				rDq.push(arr[i]);
			}
		}
		totalArea += (Math.abs(lDq.peek()[0] - rDq.peek()[0]) + 1) * lDq.peek()[1];
		System.out.println(totalArea);
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