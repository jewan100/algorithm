import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String a = sc.next();
		
		for(int i = a.length() - 5; i < a.length(); i++) {
			System.out.print(a.charAt(i));
		}
		sc.close();
	}
}