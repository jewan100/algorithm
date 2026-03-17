import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX_TRY = 10000;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_TRY; i++) {
            final int words = Integer.parseInt(br.readLine());

            if (words == 0) {
                break;
            }

            List<String> inputList = new ArrayList<>();
            for (int j = 0; j < words; j++) {
                inputList.add(br.readLine());
            }

            inputList.sort(Comparator.comparing(lhs -> lhs.toLowerCase(Locale.ROOT)));
            sb.append(inputList.stream().findFirst().get()).append("\n");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        System.out.print(sb);
    }
}