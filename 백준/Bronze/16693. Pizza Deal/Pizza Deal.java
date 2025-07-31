import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double a1 = sc.nextDouble();
		double p1 = sc.nextDouble();
		double r1 = sc.nextDouble();
		double p2 = sc.nextDouble();
		
		if(a1 / p1 > (r1 * r1 * Math.PI) / p2) {
			System.out.println("Slice of pizza");
		}else {
			System.out.println("Whole pizza");
		}
		sc.close();
	}
}