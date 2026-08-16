class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int[] hash=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[i]<dp[prev]+1){
                    dp[i]=dp[prev]+1;
                    hash[i]=prev;
                }
            }
        }

        int last=0;
        for(int i=1;i<dp.length;i++){
            if(dp[i]>dp[last]){
                last=i;
            }
        }

        while(hash[last]!=last){
            ans.add(nums[last]);
            last=hash[last];
        }
        ans.add(nums[last]);

        Collections.reverse(ans);

        return ans;
    }
}