import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] cArr = br.readLine().toCharArray();
		int rCnt = 0, bCnt = 0;
		int rs = n, re = 0, bs = n, be = 0;
		for (int i = 0; i < n; i++)
			if (cArr[i] == 'R') {
				rCnt++;
				rs = Math.min(rs, i);
				re = Math.max(re, i);
			} else {
				bCnt++;
				bs = Math.min(bs, i);
				be = Math.max(be, i);
			}
		System.out.println(Math.min(rCnt - Math.max(bs, n - 1 - be), bCnt - Math.max(rs, n - 1 - re)));
	}
}