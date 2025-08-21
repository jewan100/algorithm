import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(b == c && b != a) {
			System.out.println("A");
		}else if(a == c && a != b) {
			System.out.println("B");
		}else if(a == b && a != c) {
			System.out.println("C");
		}else {
			System.out.println("*");
		}
		sc.close();
	}
}