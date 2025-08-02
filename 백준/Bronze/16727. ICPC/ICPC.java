import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
 
        Scanner sc = new Scanner(System.in);
        
        int p1 = sc.nextInt();
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int p2 = sc.nextInt();
        
        if (p1 + p2 > s1 + s2) {
            System.out.print("Persepolis");
        }
        else if (p1 + p2 < s1 + s2) {
            System.out.print("Esteghlal");
        }
        else if (p1 + p2 == s1 + s2) {
            if (p2 > s1) {
                System.out.print("Persepolis");
            }
            else if (p2 < s1) {
                System.out.print("Esteghlal");
            }
            else {
                System.out.print("Penalty");
            }
        }
        
    }
}