import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
    
        Scanner sc = new Scanner(System.in);
        
        int money = sc.nextInt();
        double commission = (money * 0.01 + 25);
        
        if ((commission) < 100) {
            System.out.print(100);
        }
        else if (2000 < (commission)) {
            System.out.print(2000);
        }
        else {
            System.out.print(commission);    
        }
        
    }
}