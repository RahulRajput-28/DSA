class Solution {
    public int minimumDeletions(int[] nums) {
        int minEle=0;
        int maxEle=0;
        int n=nums.length;

        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[minEle])minEle=i;
            if(nums[i]>nums[maxEle])maxEle=i;
        }

        int minDis=Math.min(Math.abs(0-minEle)+1,Math.abs(n-minEle));
        int maxDis=Math.min(Math.abs(0-maxEle)+1,Math.abs(n-maxEle));

        int left=0;
        if(minEle>maxEle){
            left=minEle+1;
        }else{
            left=maxEle+1;
        }

        int right=0;
        if(minEle<maxEle){
            right=n-minEle;
        }else{
            right=n-maxEle;
        }

        return Math.min(left,Math.min(right,minDis+maxDis));
    }
}