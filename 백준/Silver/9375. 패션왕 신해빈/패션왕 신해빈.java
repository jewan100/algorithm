import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String[] sArr = br.readLine().split(" ");
				hm.putIfAbsent(sArr[1], 0);
				hm.put(sArr[1], hm.get(sArr[1]) + 1);
			}
			int answer = 1;
			for (String type : hm.keySet())
				answer *= hm.get(type) + 1;
			sb.append(answer - 1).append("\n");
		}
		System.out.println(sb);
	}
}