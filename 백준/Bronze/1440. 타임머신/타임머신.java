import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder str = new StringBuilder();

        String time = br.readLine();

        st = new StringTokenizer(time, ":");

        int[] arr = new int[3];

        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for(int h = 0; h < 3; h++){
            for(int m = 0; m < 3; m++) {
                for (int s = 0; s < 3; s++) {
                    if(h != m && m != s && s != h)
                        if(arr[h] >= 1 && arr[h] <= 12 && arr[m] >= 0 && arr[m] <= 59 && arr[s] >= 0 && arr[s] <= 59)
                            cnt++;
                }
            }
        }

        str.append(cnt);

        System.out.print(str);
        br.close();
    }
}