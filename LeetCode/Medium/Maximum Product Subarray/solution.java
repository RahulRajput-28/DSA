class Solution {
    public int maxProduct(int[] nums) {
        int maxEle=nums[0];
        int minEle=nums[0];
        int ans=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=maxEle;
                maxEle=minEle;
                minEle=temp;
            }

            maxEle=Math.max(nums[i],maxEle*nums[i]);
            minEle=Math.min(nums[i],minEle*nums[i]);
            ans=Math.max(ans,maxEle);
        }

        return ans;
    }
}