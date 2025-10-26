import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			double total = 0;
			for(int j = 0; j < n; j++) {
				String name = sc.next();
				int count = sc.nextInt();
				double cost = sc.nextDouble();
				total += count * cost;
			}
			System.out.println("$" + String.format("%.2f", total));
		}
		sc.close();
	}
}