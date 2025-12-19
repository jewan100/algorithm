import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            int answer = 0;
            boolean [] abc = new boolean[26];

            for (char ch : str.toCharArray()) {
                abc[ch - 'A'] = true;
            }

            for (int j = 0; j < 26; j++) {
                if (!abc[j]){
                    answer += 'A' + j;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}