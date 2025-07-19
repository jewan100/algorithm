import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[][][] arr = new int[3][n + 1][m + 2];
		for (int y = 1; y < n + 1; y++)
			for (int d = 0; d < 3; d++)
				Arrays.fill(arr[d][y], Integer.MAX_VALUE >> 2);
		for (int y = 1; y < n + 1; y++)
			for (int x = 1; x < m + 1; x++) {
				int p = read();
				arr[0][y][x] = p + Math.min(arr[1][y - 1][x - 1], arr[2][y - 1][x - 1]);
				arr[1][y][x] = p + Math.min(arr[0][y - 1][x], arr[2][y - 1][x]);
				arr[2][y][x] = p + Math.min(arr[0][y - 1][x + 1], arr[1][y - 1][x + 1]);
			}
		int min = Integer.MAX_VALUE;
		for (int x = 1; x < m + 1; x++)
			for (int d = 0; d < 3; d++)
				min = Math.min(min, arr[d][n][x]);
		System.out.println(min);
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