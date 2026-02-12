import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언
		
		int N = Integer.parseInt(br.readLine()); //총 트로피 수
		
		int[] trophy = new int[N];	//트로피 배열
		int top = 0;	//트로피 높이 비교용
		int left = 0;	//왼쪽에서 보이는 트로피 개수
		int right = 0;	//오른쪽에서 보이는 트로피 개수
		for(int i = 0; i<N; i++) {		//트로피 정보를 가져온다.
			trophy[i] = Integer.parseInt(br.readLine());
			if(top <trophy[i]) {
				left = left+1;
				top = trophy[i];
			}
		}
		top = 0; //높이 초기화
		for(int i = N-1; i>=0; i--) {	//트로피 정보를 가져온다.
			if(top <trophy[i]) {
				right = right+1;
				top = trophy[i];
			}
		}
		bw.write(left+"\n"+right);
	
		bw.close();
		br.close();
	}
}