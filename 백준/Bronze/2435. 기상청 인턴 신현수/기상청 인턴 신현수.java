import java.util.*;

public class Main {
	static int[] temp=new int[103];
	static int n,k,max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		k=sc.nextInt();
		
		// 온도 입력받기
		for(int i=0;i<n;i++)
			temp[i]=sc.nextInt();
		
		for(int i=0;i<=n-k;i++) {
			int sum=0;
			// 연속된 k일의 온도 합 구하기
			for(int j=0;j<k;j++)
				sum+=temp[i+j];
			
			// 온도합 작은 값으로 갱신
			if(sum>max)
				max=sum;
		}
		System.out.println(max);
	}

}