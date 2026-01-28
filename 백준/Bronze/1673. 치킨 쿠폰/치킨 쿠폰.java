import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int temp = n, add_coupon = 0;
            while(temp >= k){
                add_coupon += temp / k;
                temp = temp/k + temp%k;
            }
            System.out.println(n+add_coupon);    
        }
    }
}