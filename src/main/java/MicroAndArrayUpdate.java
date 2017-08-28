import java.util.Scanner;

/**
 * Created by sshreekantja on 8/21/2017.
 */
public class MicroAndArrayUpdate {
    public static void main(String[] args) {
        int n,k,t;
        int[] arr;
        Scanner scan = new Scanner(System.in);
        t =scan.nextInt();
        for(int testCases=0;testCases<t;testCases++) {
            n=scan.nextInt();
            k=scan.nextInt();
            arr = new int[n];
            for (int index = 0; index < n; index++) {
                arr[index] = scan.nextInt();
            }
            System.out.println(getTotalTime(arr, k, n));
        }
    }

    private static int getTotalTime(int[] arr,int k,int n) {
        int time = 0,min=Integer.MAX_VALUE;
        for(int index=0;index<n;index++){
            if(arr[index]<min){
                min=arr[index];
            }
        }
        if(min<k)
            time = k-min;
        return time;
    }
}
