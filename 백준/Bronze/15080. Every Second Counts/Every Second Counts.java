import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String[] t1 = a.split(" : ");
		String b = sc.nextLine();
		String[] t2 = b.split(" : ");
		int ttotal = 0;
		
		int total1 = Integer.parseInt(t1[0]) * 3600 + Integer.parseInt(t1[1]) * 60 + Integer.parseInt(t1[2]);
		int total2 = Integer.parseInt(t2[0]) * 3600 + Integer.parseInt(t2[1]) * 60 + Integer.parseInt(t2[2]);
		
		if(total1 <= total2) {
			ttotal = total2 - total1;
		}else {
			ttotal = 86400 - total1 + total2;
		}
		
		System.out.println(ttotal);
		sc.close();
	}
}