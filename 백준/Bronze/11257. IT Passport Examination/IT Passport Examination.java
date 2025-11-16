import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int total = 0;
			total = b + c + d;
			
			System.out.print(a + " " + total + " ");
			if(total >= 55) {
				if(b >= 35 * 0.3 && c >= 25 * 0.3 && d >= 40 * 0.3) {
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}
			}else {
				System.out.println("FAIL");
			}
		}
		sc.close();
	}
}