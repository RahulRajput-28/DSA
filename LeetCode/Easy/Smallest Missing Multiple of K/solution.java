class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int temp=k;

        for(int i=0;i<nums.length;i++){
            if(temp==nums[i]){
                temp+=k;
            }
        }

        return temp;
    }
}