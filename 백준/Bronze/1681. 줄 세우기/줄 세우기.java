import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String NOT_INCLUDED_NUM;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int studentNum = Integer.parseInt(st.nextToken());
        NOT_INCLUDED_NUM = st.nextToken();

        int count = 0;
        while (studentNum>0){
            count++;
            if (!String.valueOf(count).contains(NOT_INCLUDED_NUM)){
                studentNum--;
            }
        }

        System.out.print(count);
    }

}