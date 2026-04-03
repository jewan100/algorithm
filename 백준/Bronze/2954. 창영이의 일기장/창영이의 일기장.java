import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String answer = str.replace("apa", "a");
        answer = answer.replace("epe", "e");
        answer = answer.replace("ipi", "i");
        answer = answer.replace("opo", "o");
        answer = answer.replace("upu", "u");

        sb.append(answer);
        System.out.println(sb.toString());
    }
}