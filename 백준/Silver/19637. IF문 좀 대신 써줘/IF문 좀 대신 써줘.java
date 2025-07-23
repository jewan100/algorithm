import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		TreeMap<Integer, String> tm = new TreeMap<>();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			tm.putIfAbsent(num, str);
		}
		StringBuilder sb = new StringBuilder();
		while (m-- > 0)
			sb.append(tm.ceilingEntry(Integer.parseInt(br.readLine())).getValue()).append("\n");
		System.out.println(sb);
	}
}