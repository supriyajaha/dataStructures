/**
 * Created by hp-pc on 06-06-2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        int[] arr = new int[]{1,2,3, 4, 5, 6, 7, 8, 9};
        for(int input:arr){
           linkedList.append(input);
        }
        linkedList.printNthNode_optimized(9);
    }
}
