class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int j=0;

        while(i<nums.length){
            if(nums[i]!=nums[j]){
                nums[j+1]=nums[i];
                j++;
            }
            i++;
        }

        return j+1;
    }
}