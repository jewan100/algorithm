import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(telcheck(arr));
    }

    private static String telcheck(int[] arr) {
        if(arr[0] < 8 || arr[3] <8 ) return "answer";
        else if(arr[1] != arr[2]) return "answer";
        return "ignore";
    }
}