import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mbti = sc.nextLine();
        int count =0;
        int friend = sc.nextInt();
        for (int i = 0; i <= friend; i++) {
            String fMbti = sc.nextLine();
            if (mbti.equals(fMbti)) count++;
        }
        System.out.println(count);
    }
}