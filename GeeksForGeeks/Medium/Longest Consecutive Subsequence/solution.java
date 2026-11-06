class Solution {
    public int longestConsecutive(int[] arr) {
        // code here
        HashSet<Integer> set=new HashSet<Integer>();
        int ans=0;
        
        
        for(int num:arr){
            set.add(num);
        }
        
        for(int num:set){
            
            if(!set.contains(num-1)){
                int  count=1;
                int n=num;
                
                while(set.contains(n+1)){
                    count++;
                    n=n+1;
                }
                
                ans=Math.max(count,ans);
            }
        }
        
        return ans;
    }
}