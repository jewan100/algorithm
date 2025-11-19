import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int l = 0;
		int t = 0;
		for(int i = 0; i < 9; i++) {
			String a = sc.next();
			if(a.equals("Lion")) {
				l++;
			}else {
				t++;
			}
		}
		
		if(l > t) {
			System.out.println("Lion");
		}else {
			System.out.println("Tiger");
		}
		sc.close();
	}
}
