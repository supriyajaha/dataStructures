/**
 * Created by sshreekantja on 8/23/2017.
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] days = {1, 2, 4, 5, 7, 29, 30};
        int total = 22;
        int[] newDays = new int [total];
        for(int index = 1; index<= total; index++)
            newDays[index-1]=index;
        System.out.println(solution(newDays));
    }

    public static int solution(int[] A){
        int cost=0;
        if(A.length>=23)
            cost = 25;
        else if(A.length==1)
            cost=2;
        else {
            for (int index = 0; index < A.length; index++) {
                if(index==A.length-1){
                    cost+=2;
                }
                else {
                    int startDate = A[index];
                    int nextIndex = index + 1, days = 1;
                    while (nextIndex<A.length && A[nextIndex] < startDate + 7) {
                        days++;
                        nextIndex++;
                    }
                    if (days > 3) {
                        cost += 7;
                        index = nextIndex - 1;
                    } else
                        cost += 2;
                }
            }
        }
        return cost;
    }
}
