import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        
        int a_3 = sc.nextInt();
        int a_2 = sc.nextInt();
        int a_1 = sc.nextInt();
        int b_3 = sc.nextInt();
        int b_2 = sc.nextInt();
        int b_1 = sc.nextInt();
        
        int total_a = (a_3 * 3) + (a_2 * 2) + (a_1 * 1);
        int total_b = (b_3 * 3) + (b_2 * 2) + (b_1 * 1);
        
        if (total_a == total_b) {
            System.out.print("T");
        }
        else if (total_a > total_b) {
            System.out.print("A");
        }
        else if (total_a < total_b) {
            System.out.print("B");
        }
        
    }
}