import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		while (n-- > 0)
			hs.add(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			for (String str : br.readLine().split(","))
				hs.remove(str);
			sb.append(hs.size()).append("\n");
		}
		System.out.println(sb);
	}
}