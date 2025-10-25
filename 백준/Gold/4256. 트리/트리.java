import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] pre,in;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			
			pre = new int[n+1];
			in = new int[n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
				
			}
			
			traversal(0,0,n);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	static void traversal(int root, int s, int e) {
		int rootIdx = pre[root];
		for(int i=s; i<e; i++) {
			if(in[i] == rootIdx) {
				traversal(root+1, s,i);
				traversal(root+i+1-s, i+1,e);
				sb.append(rootIdx +" ");
			}
		}
	}
}