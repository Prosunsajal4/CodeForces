import java.util.*;
import java.io.*;

public class Deadlines {
    static class FenwickTree {
        long[] tree;
        int n;
        FenwickTree(int n) {
            this.n = n;
            tree = new long[n + 1];
            Arrays.fill(tree, 0);
        }
        void update(int i, long val) {
            for (; i <= n; i += i & -i) tree[i] = Math.max(tree[i], val);
        }
        long query(int i) {
            long res = 0;
            for (; i > 0; i -= i & -i) res = Math.max(res, tree[i]);
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(st.nextToken());

            List<List<Integer>> events = new ArrayList<>();
            for (int i = 0; i <= n + 2; i++) events.add(new ArrayList<>());
            for (int j = 1; j <= n; j++) {
                int avail = j + a[j] + 1;
                if (avail <= n + 1) events.get(avail).add(j);
            }

            FenwickTree ft = new FenwickTree(n);
            long[] dp = new long[n + 1];
            long maxDp = 0;

            for (int i = 1; i <= n; i++) {
                for (int j : events.get(i)) ft.update(j, dp[j]);
                
                int limit = i - a[i] - 1;
                long best = 0;
                if (limit >= 1) best = ft.query(Math.min(limit, n));
                
                dp[i] = a[i] + best;
                maxDp = Math.max(maxDp, dp[i]);
            }
            sb.append(maxDp).append('\n');
        }
        System.out.print(sb);
    }
}
