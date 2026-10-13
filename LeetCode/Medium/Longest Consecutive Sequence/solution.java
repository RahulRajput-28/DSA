class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int maxlen=0;

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int n:set){
            if(!set.contains(n-1)){
            int num=n;
            int count=1;

            while(set.contains(num+1)){
                count++;
                num++;
            }

            maxlen=Math.max(maxlen,count);
            }
        }

        return maxlen;
    }
}