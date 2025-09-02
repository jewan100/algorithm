import  java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			String a = sc.next();
			int count = 0;
			for(int j = 0; j < a.length(); j++) {
				if(a.charAt(j) == 'D') {
					break;
				}
				count++;
			}
			System.out.println(count);
		}
		sc.close();
	}
}