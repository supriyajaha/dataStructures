import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by sshreekantja on 8/21/2017.
 */
public class MonkAndPowerOfTime {
    public static void main(String[] args) {
        int n;
        Queue<Integer> callingOrder = new LinkedList<Integer>(), idealOrder = new LinkedList<Integer>();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int index = 0; index < n; index++) {
            callingOrder.add(scan.nextInt());
        }
        for (int index = 0; index < n; index++) {
            idealOrder.add(scan.nextInt());
        }
        System.out.println(getCost(callingOrder, idealOrder));
    }

    private static int getCost(Queue<Integer> callingOrder, Queue<Integer> idealOrder) {
        int cost = 0;
        while (callingOrder.size() != 0) {
            if (callingOrder.peek().equals(idealOrder.peek())) {
                callingOrder.remove();
                idealOrder.remove();
                cost++;
            } else {
                while (!callingOrder.peek().equals(idealOrder.peek())) {
                    callingOrder.add(callingOrder.remove());
                    cost++;
                }
            }
        }
        return cost;
    }
}
