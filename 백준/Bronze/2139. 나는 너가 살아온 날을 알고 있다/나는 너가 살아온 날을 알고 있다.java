import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [] arr = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, };

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            if (day == 0 && month == 0 && year == 0){
                break;
            }

            int answer = 0;
            boolean year29 = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

            if (year29 && month > 2){
                answer++;
            }

            for (int i = 0; i < month; i++) {
                answer += arr[i];
            }

            answer += day;

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}