import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        
        for (int i = 0; i < testCase; i++) {
            int[] decArr = new int[10];
            String[] numArr = sc.next().split("");
            for (String n : numArr) {
                decArr[Integer.parseInt(n)] = 1;
            }
            
            int count = 0;
            for (int d : decArr) {
                count += d;
            }
            
            System.out.println(count);
        }
    }
}