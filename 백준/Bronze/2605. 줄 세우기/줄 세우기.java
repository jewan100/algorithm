import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		ArrayList<Integer> move = new ArrayList<>();
		move.add(0);
		
		for(int i=1; i<=n; i++) {
			arr[i] = i;
			move.add(i);
		}

		for(int i=1; i<=n; i++) {
			int movelen = sc.nextInt();
			int nownum = arr[i];
			move.remove(i);
			move.add(i-movelen, nownum);
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(move.get(i)+" ");
		}
	}
}