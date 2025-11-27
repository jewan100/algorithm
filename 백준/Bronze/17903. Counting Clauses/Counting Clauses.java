import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		if(m >= 8) {
			System.out.println("satisfactory");
		}else {
			System.out.println("unsatisfactory");
		}
		sc.close();
	}
}