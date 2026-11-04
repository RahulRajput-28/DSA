import java.util.*;

class Solution {
    int m;
    long[] cnt, sum;

    void upd(int i, long c, long s) {
        for (i++; i <= m; i += i & -i) { cnt[i] += c; sum[i] += s; }
    }

    // returns index (0-based) of the k-th smallest (k is 1-based)
    int kth(long k) {
        int pos = 0;
        int log = Integer.highestOneBit(m);
        for (int step = log; step > 0; step >>= 1) {
            int nxt = pos + step;
            if (nxt <= m && cnt[nxt] < k) {
                pos = nxt;
                k -= cnt[nxt];
            }
        }
        return pos; // 0-based index
    }

    long[] prefix(int idx) { // counts and sums for indices 0..idx
        long c = 0, s = 0;
        for (int i = idx + 1; i > 0; i -= i & -i) { c += cnt[i]; s += sum[i]; }
        return new long[]{c, s};
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] vals = Arrays.stream(sorted).distinct().toArray();
        m = vals.length;
        cnt = new long[m + 1];
        sum = new long[m + 1];

        int[] id = new int[n];
        for (int i = 0; i < n; i++) id[i] = Arrays.binarySearch(vals, nums[i]);

        int W = n - x + 1;
        long[] cost = new long[W];
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            upd(id[i], 1, nums[i]);
            totalSum += nums[i];
            if (i >= x) {
                upd(id[i - x], -1, -nums[i - x]);
                totalSum -= nums[i - x];
            }
            if (i >= x - 1) {
                int mi = kth((x + 1) / 2);
                long med = vals[mi];
                long[] p = prefix(mi);
                long leftCnt = p[0], leftSum = p[1];
                long rightCnt = x - leftCnt, rightSum = totalSum - leftSum;
                cost[i - x + 1] = med * leftCnt - leftSum + rightSum - med * rightCnt;
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) Arrays.fill(row, INF);
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i >= x && dp[i - x][j - 1] < INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + cost[i - x]);
                }
            }
        }
        return dp[n][k];
    }
}