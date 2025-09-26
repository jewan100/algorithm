import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if(y>x){
            System.out.println(y-x);
        }else{
            System.out.println(x+y);
        }
    }
}