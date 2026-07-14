import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long prefixSum = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                prefixSum += sc.nextLong();
                long minRequired = (long)(i + 1) * (i + 2) / 2;
                if (prefixSum < minRequired) {
                    possible = false;
                }
            }
            System.out.println(possible ? "YES" : "NO");
        }
    }
}
