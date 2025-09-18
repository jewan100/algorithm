import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Coupon = Integer.parseInt(br.readLine());
        int price = Integer.parseInt(br.readLine());
        double totalPrice = 0;

        if (Coupon < 5) {
            totalPrice = price;
        } else if (Coupon >= 5 && Coupon < 10) {
            totalPrice = price - 500;
        } else if (Coupon >= 10 && Coupon < 15) {
            totalPrice = Math.min((price * 0.9), (price - 500));
        } else if (Coupon >= 15 && Coupon < 20) {
            totalPrice = Math.min(((price * 0.9)), (price - 2000));
            totalPrice = Math.min(totalPrice, price - 500);
        } else if (Coupon >= 20) {
            totalPrice = Math.min((price - 2000), (price * 0.75));
            totalPrice = Math.min(totalPrice, price - 500);
        }

        if (totalPrice < 0) {
            totalPrice = 0;
        }

        sb.append((int) totalPrice);
        System.out.println(sb.toString());
    }
}