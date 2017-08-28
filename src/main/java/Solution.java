import java.util.ArrayList;
import java.util.List;

/**
 * Created by sshreekantja on 8/23/2017.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("T","J"));
    }
    public static int solution(String A, String B){
        int win=0;
        List<String> order = new ArrayList<String>();
        order.add("A");
        order.add("K");
        order.add("Q");
        order.add("J");
        order.add("T");
        order.add("9");
        order.add("8");
        order.add("7");
        order.add("6");
        order.add("5");
        order.add("4");
        order.add("3");
        order.add("2");

       for(int index=0;index<A.length();index++){
           String achar = ""+A.charAt(index);
           String bchar = ""+B.charAt(index);
           int a = order.indexOf(achar);
           int b = order.indexOf(bchar);
           if(a < b)
                win++;
        }
        return win;
    }
}
