import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for(int i = 0 ; i< 10; i++){
            int inputInt = Integer.parseInt(br.readLine());
            sum += inputInt;
            if (hm.containsKey(inputInt)){
                hm.replace(inputInt, hm.get(inputInt) + 1);
            } else {
                hm.put(inputInt, 1);
            }
        }
        int avg = sum / 10;

        Set<Integer> keyset = hm.keySet();
        Iterator<Integer> iterator = keyset.iterator();

        int mostValue = 0;
        int mostKey = 0;
        while(iterator.hasNext()){
            int thisKey = iterator.next();
            int thisValue = hm.get(thisKey);
            if (thisValue > mostValue){
                mostValue = thisValue;
                mostKey = thisKey;
            }
        }

        sb.append(avg).append("\n").append(mostKey);
        System.out.println(sb);
    }
}