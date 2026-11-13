import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<long[]> dq = new ArrayDeque<>(); 
        long sumMax = 0;  
        long sumVal = 0; 
        long ans = 0;
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            long x = nums[l];
            long cnt = 1;

            while (!dq.isEmpty() && dq.peekFirst()[0] <= x) {
                long[] b = dq.pollFirst();
                sumMax -= b[0] * b[1];
                cnt += b[1];
            }
            dq.offerFirst(new long[]{x, cnt});
            sumMax += x * cnt;
            sumVal += x;

            while (sumMax - sumVal > k) {
                long[] last = dq.peekLast();
                sumMax -= last[0];
                sumVal -= nums[r];
                last[1]--;
                if (last[1] == 0) dq.pollLast();
                r--;
            }

            ans += r - l + 1;
        }
        return ans;
    }
}