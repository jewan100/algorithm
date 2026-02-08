import java.util.Scanner;

public class Main {
    static char agct[] = {'A', 'G', 'C', 'T'};

    static char arr[][] = { // 염기서열 해독표
            {'A', 'C', 'A', 'G'},
            {'C', 'G', 'T', 'A'},
            {'A', 'T', 'C', 'G'},
            {'G', 'A', 'G', 'T'}
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 염기 서열의 길이
        String s = in.next(); // 염기서열을 나타내는 길이가 N인 문자열

        int num = charToInt(s.charAt(N - 1));

        for (int i = N - 1; i > 0; i--) {
            int idx1 = charToInt(s.charAt(i - 1));
            int idx2 = num;

            // 제일 끝에 있는 두 개의 염기를 하나의 염기로 바꾸기
            char c = arr[idx1][idx2];
            num = charToInt(c);
        }

        // 출력
        System.out.println(agct[num]);
    }

    // 문자를 agct의 순서에 맞춰 숫자로 바꿔준다.
    public static int charToInt(char c) {
        int num = 0;

        for (int i = 0; i < 4; i++) {
            if (c == agct[i]) {
                num = i;
                break;
            }
        }

        return num;
    }
}