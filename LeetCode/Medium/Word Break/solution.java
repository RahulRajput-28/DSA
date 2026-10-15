class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxlen=0;

        for(String word:wordDict){
            maxlen=Math.max(maxlen,word.length());
        }

        boolean[] dp=new boolean[s.length()+1];

        dp[0]=true;

        for(int i=1;i<=s.length();i++){

            for(int j=i;j>=Math.max(0,i-maxlen);j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}