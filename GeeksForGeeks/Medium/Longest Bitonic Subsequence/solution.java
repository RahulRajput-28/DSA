class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        int maxi=0;
        
        for(int i=0;i<nums.length;i++){
            dp1[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp1[i]<dp1[j]+1){
                    dp1[i]=dp1[j]+1;
                }
            }
        }
        
        for(int i=nums.length-1;i>=0;i--){
            dp2[i]=1;
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]>nums[j] && dp2[i]<dp2[j]+1){
                    dp2[i]=dp2[j]+1;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(dp1[i] > 1 && dp2[i] > 1) {
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
            }
        }
        
        return maxi;
        
    }
}
