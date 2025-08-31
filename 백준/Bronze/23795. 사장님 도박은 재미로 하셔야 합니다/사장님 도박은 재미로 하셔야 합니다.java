import java.util.Scanner;

public class Main {	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int sum=0;
		
		while(true) {
			int n=scanner.nextInt();
			
			if(n<0) {
				break;
			}else {
				sum=sum+n;
			}
		}
		System.out.println(sum);
    }
}