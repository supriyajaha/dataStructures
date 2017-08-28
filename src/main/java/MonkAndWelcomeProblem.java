import java.util.Scanner;

/**
 * Created by sshreekantja on 8/21/2017.
 */
public class MonkAndWelcomeProblem {
    public static void main(String[] args) {
        int n;
        int[] a, b,c;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        a = new int[n];
        b = new int[n];
        for (int index = 0; index < n; index++) {
            a[index] = scan.nextInt();
        }
        for (int index = 0; index < n; index++) {
            b[index] = scan.nextInt();
        }
        c = getSumArray(a,b,n);
        for (int index = 0; index < n; index++) {
            if(index==n-1)
                System.out.print(c[index]);
            else
                System.out.print(c[index]+" ");
        }
    }

    private static int[] getSumArray(int[] a, int[] b, int n) {
        int[] c = new int[n];
        for (int index = 0; index < n; index++) {
            c[index] = a[index]+b[index];
        }
        return c;
    }
}

