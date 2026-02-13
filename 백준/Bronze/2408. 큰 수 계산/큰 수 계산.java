import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Character> opt = new LinkedList<>();
        LinkedList<BigInteger> list = new LinkedList<>();
        list.push(new BigInteger(br.readLine()));

        while(N --> 1) {
            char nextOpt = br.readLine().charAt(0);
            BigInteger next = new BigInteger(br.readLine());

            if(nextOpt == '+' || nextOpt == '-') {
                list.add(next);
                opt.add(nextOpt);
            } else if(nextOpt == '*') {
                list.add(list.pollLast().multiply(next));
            } else {
                if(list.getLast().compareTo(BigInteger.ZERO) != next.compareTo(BigInteger.ZERO)) {
                    list.add(list.pollLast().subtract(next.subtract(BigInteger.ONE)).divide(next));
                } else {
                    list.add(list.pollLast().divide(next));
                }
            }
        }

        BigInteger BI = list.get(0);

        for(int i = 0; i < opt.size(); i++) {
            if(opt.get(i) == '+') {
                BI = BI.add(list.get(i + 1));
            } else {
                BI = BI.subtract(list.get(i + 1));
            }
        }

        bw.write(BI.toString());
        bw.close();
    }
}