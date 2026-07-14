import java.util.Scanner;

public class Garland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.next();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = (s.charAt(i) - '0') ^ ((i + 1) % 2);
            }
            int[] prefix = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                prefix[i + 2] = prefix[i + 1] + (b[i] != b[i + 1] ? 1 : 0);
            }
            for (int i = 0; i < q; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                int trans = prefix[r] - prefix[l];
                int ops = (trans + 1) / 2;
                sb.append(ops <= k ? "YES" : "NO").append('\n');
            }
        }
        System.out.print(sb);
    }
}
