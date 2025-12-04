import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
        // 싸이를 위해(??) 단위를 바꿔주는 프로그램

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double number = Double.parseDouble(st.nextToken());
            String str = st.nextToken();

            double answerA = 0;
            String answerB = "";
            String chagneAnswer = "";

            if (str.equals("kg")){
                answerB = "lb";
                answerA = number * 2.2046;
                chagneAnswer = String.format("%.4f", answerA);
            }else if(str.equals("l")){
                answerB = "g";
                answerA = number * 0.2642;
                chagneAnswer = String.format("%.4f", answerA);
            } else if ((str.equals("lb"))) {
                answerB = "kg";
                answerA = number * 0.4536;
                chagneAnswer = String.format("%.4f", answerA);
            } else if (str.equals("g")) {
                answerB = "l";
                answerA = number * 3.7854;
                chagneAnswer = String.format("%.4f", answerA);
            }

            sb.append(chagneAnswer).append(" ").append(answerB).append("\n");
        }

        System.out.println(sb.toString());
    }
}