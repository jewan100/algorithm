import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int total1;
		int total2;
		int total3;
		
		total1 = 2 * b + 4 * c;
		total2 = 2 * a + 2 * c;
		total3 = 4 * a + 2 * b;
		
		if(total1 >= total2 && total2 >= total3 || total2 >= total1 && total1 >= total3) {
			System.out.println(total3);
		}else if(total1 >= total3 && total3 >= total2 || total3 >= total1 && total1 >= total2) {
			System.out.println(total2);
		}else {
			System.out.println(total1);
		}
		sc.close();
	}
}