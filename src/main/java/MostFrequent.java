import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sshreekantja on 8/21/2017.
 */
public class MostFrequent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> arr = new HashMap<Integer, Integer>();
        Integer n = scan.nextInt(),maxCount = 1, min = Integer.MAX_VALUE;
        for (int index = 0; index < n; index++) {
            Integer num = scan.nextInt();
            Integer numCount = arr.get(num);
            if (numCount == null) {
                arr.put(num, 1);
            } else {
                numCount++;
                arr.put(num, numCount);
                if (maxCount < numCount) {
                    maxCount = numCount;
                    if (min > num) {
                        min = num;
                    }
                }
            }

        }
        System.out.println(min);
    }
}

