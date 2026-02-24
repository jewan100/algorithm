import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k,sz,i,j;
		k = Integer.parseInt(br.readLine());
		String str = br.readLine();
		sz = str.length();
		for(i=0;i<k;i++) for(j=0;j<sz/k;j++) sb.append(str.charAt(j%2==0?j*k+i:j*k+k-1-i));
		System.out.println(sb);
	}
}