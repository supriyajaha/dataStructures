import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sshreekantja on 8/21/2017.
 */
public class MonksLoveForFood {
    public static void main(String[] args) {
        Integer t,query,cost;
        Scanner scan = new Scanner(System.in);
        t = scan.nextInt();
        Stack<Integer> foodPile = new Stack<Integer>();
        for (int testCases = 0; testCases < t; testCases++) {
            query=scan.nextInt();
            switch (query){
                case 1:
                    if(foodPile.size()==0)
                        System.out.println("No Food");
                    else
                        System.out.println(foodPile.pop());
                    break;
                case 2:
                    foodPile.push(scan.nextInt());
                    break;
            }
        }
    }
}
