import java.util.*;

class Solution {
    private int n;
    private long[] dummy; // unused, keeps the class simple
    private int[] bit;

    private void bitUpdate(int i, int val) {
        for (i++; i <= n + 1; i += i & -i) bit[i] ^= val;
    }

    private int bitQuery(int i) {
        int res = 0;
        for (i++; i > 0; i -= i & -i) res ^= bit[i];
        return res;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;

        // adjacency via arrays
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[2 * (n - 1) + 1];
        int[] to = new int[2 * (n - 1) + 1];
        int ec = 0;
        for (int[] e : edges) {
            to[ec] = e[1]; nxt[ec] = head[e[0]]; head[e[0]] = ec++;
            to[ec] = e[0]; nxt[ec] = head[e[1]]; head[e[1]] = ec++;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        int[][] up = new int[LOG][n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] mask = new int[n];
        int[] base = new int[n];
        for (int i = 0; i < n; i++) mask[i] = 1 << (s.charAt(i) - 'a');

        // iterative DFS
        int[] cur = head.clone();
        int[] stack = new int[n];
        int sp = 0, timer = 0;
        stack[sp++] = 0;
        tin[0] = timer++;
        base[0] = mask[0];
        up[0][0] = 0;
        while (sp > 0) {
            int v = stack[sp - 1];
            int e = cur[v];
            if (e == -1) {
                tout[v] = timer - 1;
                sp--;
                continue;
            }
            cur[v] = nxt[e];
            int w = to[e];
            if (w == up[0][v]) continue; // parent (root's "parent" is 0 = itself, never a neighbor)
            up[0][w] = v;
            depth[w] = depth[v] + 1;
            base[w] = base[v] ^ mask[w];
            tin[w] = timer++;
            stack[sp++] = w;
        }

        for (int j = 1; j < LOG; j++)
            for (int v = 0; v < n; v++)
                up[j][v] = up[j - 1][up[j - 1][v]];

        bit = new int[n + 2];
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int x = Integer.parseInt(p[1]);
                int nw = 1 << (p[2].charAt(0) - 'a');
                int d = mask[x] ^ nw;
                if (d != 0) {
                    bitUpdate(tin[x], d);
                    bitUpdate(tout[x] + 1, d);
                    mask[x] = nw;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                // LCA
                int a = u, b = v;
                if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
                int diff = depth[a] - depth[b];
                for (int j = 0; j < LOG; j++)
                    if (((diff >> j) & 1) != 0) a = up[j][a];
                int l;
                if (a == b) {
                    l = a;
                } else {
                    for (int j = LOG - 1; j >= 0; j--) {
                        if (up[j][a] != up[j][b]) {
                            a = up[j][a];
                            b = up[j][b];
                        }
                    }
                    l = up[0][a];
                }

                int pu = base[u] ^ bitQuery(tin[u]);
                int pv = base[v] ^ bitQuery(tin[v]);
                int m = pu ^ pv ^ mask[l];
                ans.add((m & (m - 1)) == 0);
            }
        }
        return ans;
    }
}