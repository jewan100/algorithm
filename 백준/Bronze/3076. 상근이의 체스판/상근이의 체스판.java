import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] RC = new int [2];
        int [] AB = new int [2];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0;i<2;i++)
            RC[i] = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<2;i++)
            AB[i] = Integer.parseInt(st2.nextToken());
        
        for(int R=0; R<RC[0];R++){
            for(int A =0; A<AB[0];A++){
                if((R%2)==0){
                    for(int C=0; C<RC[1]/2;C++){
                        for(int B=0; B<AB[1];B++)
                            System.out.print("X");
                        for(int B=0; B<AB[1];B++)
                            System.out.print(".");
                    }
                    if((RC[1]%2)==1){
                        for(int B=0; B<AB[1];B++)
                            System.out.print("X");
                    }
 
                }
                else{
                    for(int C=0; C<RC[1]/2;C++){
                        for(int B=0; B<AB[1];B++)
                            System.out.print(".");
                        for(int B=0; B<AB[1];B++)
                            System.out.print("X");
                    }
                    if((RC[1]%2)==1){
                        for(int B=0; B<AB[1];B++)
                            System.out.print(".");
                        }
                }
        System.out.println();
            }
        }
    }
}