import java.util.*;

public class Trees {
    static List<List<Integer>> adj;
    static int[] a, minVal, maxVal;
    static boolean[] ok;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
            a = new int[n + 1];
            minVal = new int[n + 1];
            maxVal = new int[n + 1];
            ok = new boolean[n + 1];
            for (int i = 2; i <= n; i++) {
                int p = sc.nextInt();
                adj.get(p).add(i);
            }
            for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
            dfs(1);
            sb.append(ok[1] ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int u) {
        List<Integer> ch = adj.get(u);
        if (ch.isEmpty()) {
            minVal[u] = maxVal[u] = a[u];
            ok[u] = true;
            return;
        }
        for (int v : ch) dfs(v);
        for (int v : ch) if (!ok[v]) { ok[u] = false; return; }

        minVal[u] = Integer.MAX_VALUE;
        maxVal[u] = Integer.MIN_VALUE;
        for (int v : ch) {
            minVal[u] = Math.min(minVal[u], minVal[v]);
            maxVal[u] = Math.max(maxVal[u], maxVal[v]);
        }

        int m = ch.size();
        int breaks = 0;
        for (int i = 0; i < m; i++) {
            int v1 = ch.get(i), v2 = ch.get((i + 1) % m);
            if (maxVal[v1] + 1 != minVal[v2]) breaks++;
        }

        ok[u] = breaks <= 1;
    }
}
