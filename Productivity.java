import java.util.Scanner;
import java.util.Arrays;

public class Productivity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            int[] b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            Arrays.sort(b);

            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + a[i];

            long[] S = new long[m + 1];
            S[0] = prefix[b[0]];
            for (int k = 1; k < m; k++) S[k] = prefix[b[k]] - prefix[b[k - 1]];
            S[m] = prefix[n] - prefix[b[m - 1]];

            long even = S[m], odd = Long.MIN_VALUE / 2;
            for (int k = m - 1; k >= 0; k--) {
                long newEven = S[k] + Math.max(even, odd);
                long newOdd = -S[k] + Math.max(odd, even);
                even = newEven;
                odd = newOdd;
            }
            sb.append(Math.max(even, odd)).append('\n');
        }
        System.out.print(sb);
    }
}
