import java.util.Scanner;

public class Drawings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int maxLen = 0, cur = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '#') {
                    cur++;
                    maxLen = Math.max(maxLen, cur);
                } else {
                    cur = 0;
                }
            }
            System.out.println((maxLen + 1) / 2);
        }
    }
}
