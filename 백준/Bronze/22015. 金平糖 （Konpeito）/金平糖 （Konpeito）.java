import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> nums = new ArrayList<>();
        nums.add(Integer.parseInt(st.nextToken()));
        nums.add(Integer.parseInt(st.nextToken()));
        nums.add(Integer.parseInt(st.nextToken()));

        nums.sort(Comparator.naturalOrder());
        System.out.println((nums.get(2) - nums.get(1)) + (nums.get(2) - nums.get(0)));

    }
}