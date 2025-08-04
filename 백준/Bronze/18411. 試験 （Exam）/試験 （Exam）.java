import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int total = 0;
		
		if(a >= b && b >= c || b >= a && a >= c) {
			total += a + b;
		}else if(a >= c && c >= b || c >= a && a >= b) {
			total += a + c;
		}else {
			total += b + c;
		}
		
		System.out.println(total);
		sc.close();
	}
}