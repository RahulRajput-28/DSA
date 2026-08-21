class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int posi=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int neg=nums[0]*nums[1]*nums[nums.length-1];

        int ans=Math.max(posi,neg);

        return ans;
    }
}