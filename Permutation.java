import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int g = gcd(x, y);
            boolean possible = true;
            for (int i = 1; i <= n; i++) {
                int p = sc.nextInt();
                if (p % g != i % g) {
                    possible = false;
                }
            }
            sb.append(possible ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
