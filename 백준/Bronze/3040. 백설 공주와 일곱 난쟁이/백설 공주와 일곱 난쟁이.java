import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                int current = arr[i] + arr[j];
                if (sum - current == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) System.out.println(arr[k]);
                    }
                }
            }
        }
    }
}