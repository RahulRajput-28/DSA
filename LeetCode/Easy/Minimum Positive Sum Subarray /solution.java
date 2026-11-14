class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int len = l; len <= r && i + len <= n; len++) {
                int s = prefix[i + len] - prefix[i];
                if (s > 0 && s < best) {
                    best = s;
                }
            }
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}