import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t1 = sc.nextInt();
		int v1 = sc.nextInt();
		int t2 = sc.nextInt();
		int v2 = sc.nextInt();
		
		if(t2 < 0 && v2 >= 10) {
			System.out.println("A storm warning for tomorrow! Be careful and stay home if possible!");
		}else if(t1 > t2) {
			System.out.println("MCHS warns! Low temperature is expected tomorrow.");
		}else if(v1 < v2) {
			System.out.println("MCHS warns! Strong wind is expected tomorrow.");
		}else {
			System.out.println("No message");
		}
		sc.close();
	}
}