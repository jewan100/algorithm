import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] student_classes = new int[num][5];
        for(int i = 0; i < num; i++){
            for(int j = 0; j <5 ; j++){
                student_classes[i][j] = sc.nextInt();
            }
        }
        //구현
        int max = 0;
        int leader = 0;
        for(int i = 0; i<num; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<5; j++){
                for(int k = 0; k<num; k++){
                    if(student_classes[i][j] == student_classes[k][j]
                            && i!=k){
                        set.add(k);
                    }
                }
            }
            if(set.size()>max) {
                leader = i;
                max = set.size();
            }
        }
        System.out.println(leader + 1);
    }
}