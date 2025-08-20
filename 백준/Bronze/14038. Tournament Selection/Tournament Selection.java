import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		for(int i = 0; i < 6; i++) {
			String a = sc.next();
			if(a.equals("W")) {
				count++;
			}
		}
		
		if(5 <= count && count <= 6) {
			System.out.println("1");
		}else if(3 <= count && count <= 4) {
			System.out.println("2");
		}else if(1 <= count && count <= 2) {
			System.out.println("3");
		}else {
			System.out.println("-1");
		}
		sc.close();
	}
}