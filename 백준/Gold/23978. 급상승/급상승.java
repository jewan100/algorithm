import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long k;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st.nextToken());
		long l = 0, r = 1_500_000_000L;
		while (l <= r) {
			long target = (l + r) >> 1;
			if (isPossible(target))
				r = target - 1;
			else
				l = target + 1;
		}
		System.out.println(l);
	}

	private static boolean isPossible(long target) {
		long sum = 0;
		for (int i = 0; i < n - 1; i++) {
			long diff = arr[i + 1] - arr[i];
			sum += ((target * (target + 1)) >> 1);
			if (target > diff)
				sum -= (((target - diff) * ((target - diff) + 1)) >> 1);
			if (sum >= k)
				return true;
		}
		sum += (target * (target + 1)) >> 1;
		return sum >= k;
	}
}