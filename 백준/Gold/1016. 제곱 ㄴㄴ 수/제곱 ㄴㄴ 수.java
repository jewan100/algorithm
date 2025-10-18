import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken()), max = Long.parseLong(st.nextToken());

		int cnt = (int) (max - min + 1);
		boolean[] bArr = new boolean[cnt];
		for (long i = 2; i <= Math.sqrt(max); i++) {
			long pow = (long) Math.pow(i, 2);

			long s = ((min + pow - 1) / pow) * pow;

			for (; s <= max; s += pow) {
				int idx = (int) (s - min);
				if (!bArr[idx]) {
					bArr[idx] = true;
					cnt--;
				}
			}
		}
		System.out.println(cnt);
	}
}