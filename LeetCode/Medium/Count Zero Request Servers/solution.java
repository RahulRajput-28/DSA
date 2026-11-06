import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int qLen = queries.length;
        Integer[] order = new Integer[qLen];
        for (int i = 0; i < qLen; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] cnt = new int[n + 1];
        int active = 0;
        int left = 0, right = 0;
        int m = logs.length;
        int[] ans = new int[qLen];

        for (int idx : order) {
            int q = queries[idx];

            // add logs with time <= q
            while (right < m && logs[right][1] <= q) {
                int s = logs[right][0];
                if (cnt[s] == 0) active++;
                cnt[s]++;
                right++;
            }

            // remove logs with time < q - x
            while (left < right && logs[left][1] < q - x) {
                int s = logs[left][0];
                cnt[s]--;
                if (cnt[s] == 0) active--;
                left++;
            }

            ans[idx] = n - active;
        }

        return ans;
    }
}