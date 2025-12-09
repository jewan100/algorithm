import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a1 = sc.nextInt();
			int p1 = sc.nextInt();
			int r1 = sc.nextInt();
			int p2 = sc.nextInt();
			int aPrice = a1 / p1;
			int rPrice = (int)(r1 * r1 * Math.PI / p2);
			if(aPrice > rPrice) {
				System.out.println("Slice of pizza");
			}else if(aPrice < rPrice) {
				System.out.println("Whole pizza");
			}
		}
		sc.close();
	}
}