import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sshreekantja on 8/21/2017.
 */
public class WeighingTheStones {
    public static void main(String[] args) {
        int n, t, ankits_max_weight_count, rupams_max_weight_count;

        Scanner scan = new Scanner(System.in);
        t = scan.nextInt();
        for (int testCases = 0; testCases < t; testCases++) {
            n = scan.nextInt();
            Map<Integer, Integer> rupam = new HashMap<Integer, Integer>(), ankit = new HashMap<Integer, Integer>();
            int weight1 = getMap(rupam, n, scan);
            int weight2 = getMap(ankit, n, scan);
            String str;
            if(weight1>weight2)
                str= "Rupam";
            else if(weight2 > weight1)
                str= "Ankit";
            else
                str= "Tie";
            System.out.println(str);
            //System.out.println(getWinner(rupam, ankit, rupams_max_weight_count,ankits_max_weight_count));
        }
    }

    private static int getMap(Map<Integer, Integer> weights, int n, Scanner scan) {
        int count = 1,max= Integer.MIN_VALUE;
        for (int index = 0; index < n; index++) {
            int weight = scan.nextInt();
            Integer weightCount = weights.get(weight);
            if (weightCount == null)
                weights.put(weight, 1);
            else {
                weightCount++;
                weights.put(weight, weightCount);
                if(count<weightCount) {
                    count = weightCount;
                    if(max<weight){
                        max=weight;
                    }
                }
            }
        }
        return max;
    }

    private static String getWinner(Map<Integer, Integer> rupam, Map<Integer, Integer> ankit, int rupams_max_weight_count, int ankits_max_weight_count) {
        int weight1 = getMaximumWeighedStone(rupam,rupams_max_weight_count);
        int weight2 = getMaximumWeighedStone(ankit,ankits_max_weight_count);
        if(weight1>weight2)
            return "Rupam";
        else if(weight2 > weight1)
            return "Ankit";
        else
            return "Tie";
    }

    private static int getMaximumWeighedStone(Map<Integer, Integer> weights, Integer max_weight_count) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> weightEntry:weights.entrySet()) {
            Integer value = weightEntry.getValue();
            Integer key = weightEntry.getKey();
            if(value.equals(max_weight_count)){
                if(max < key)
                    max=key;
            }
        }
        return max;
    }
}
