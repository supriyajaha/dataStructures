/**
 * Created by hp-pc on 06-06-2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        int[] arr = new int[]{1,2,1,2,1,3,1};
        for(int input:arr){
           linkedList.append(input);
        }
        System.out.println(linkedList.count(1));
    }
}
