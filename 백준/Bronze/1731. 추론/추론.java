import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] n = new int[num];

		for (int i = 0; i < n.length; i++) {
			n[i] = scan.nextInt();
		}
		scan.close();

		if (n[2] - n[1] == n[1] - n[0])
			System.out.println(n[n.length - 1] + (n[1] - n[0]));
		else
			System.out.println(n[n.length - 1] * (n[1] / n[0]));
	}
}