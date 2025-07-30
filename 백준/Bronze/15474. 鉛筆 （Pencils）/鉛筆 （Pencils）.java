import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int totalX = 0;
		int totalY = 0;
		
		if(n % a == 0) {
			totalX = (n / a) * b;
		}else {
			totalX = (n / a + 1) * b;
		}
		
		if(n % c == 0) {
			totalY = (n / c) * d;
		}else {
			totalY = (n / c + 1) * d;
		}
		
		if(totalX > totalY) {
			System.out.println(totalY);
		}else {
			System.out.println(totalX);
		}
		sc.close();
	}
}