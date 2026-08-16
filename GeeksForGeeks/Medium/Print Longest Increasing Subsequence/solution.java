class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int[] dp=new int[arr.length];
        int[] hash=new int[arr.length];
        ArrayList<Integer> ans=new ArrayList<>();
        
        Arrays.fill(dp,1);
        
        for(int i=0;i<arr.length;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[prev]<arr[i] && dp[prev]+1>dp[i]){
                    dp[i]=dp[prev]+1;
                    hash[i]=prev;
                }
            }
        }
        
        
        int last=0;
        
        for(int i=0;i<dp.length;i++){
            if(dp[i]>dp[last]){
                last=i;
            }
        }
        
        while(hash[last]!=last){
            ans.add(arr[last]);
            last=hash[last];
        }
        ans.add(arr[last]);
        
        Collections.reverse(ans);
        
        return ans;
    }
}
