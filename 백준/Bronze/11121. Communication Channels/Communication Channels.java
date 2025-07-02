import java.util.Scanner;
 
public class Main {
 
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            String inputBianry = sc.next();
            String outputBianry = sc.next();
            
            if (inputBianry.equals(outputBianry)) {
                System.out.println("OK");
            }
            else {
                System.out.println("ERROR");
            }
        }
 
    }
}