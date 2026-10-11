class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int countZero=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                product*=nums[i];
            }else{
                countZero++;
            }
        }

        int[] ans=new int[nums.length];

        for(int i=0;i<ans.length;i++){
            if(countZero>1){
                ans[i]=0;
            }else if(countZero==1){
                if(nums[i]==0){
                    ans[i]=product;
                }
            }else{
                ans[i]=product/nums[i];
            }
        }

        return ans;
    }
}