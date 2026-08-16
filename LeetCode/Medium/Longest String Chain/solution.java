class Solution {
    boolean helper(String s1,String s2){
        if(s1.length()+1!=s2.length())return false;

        int l=0;
        int r=0;

        while(l<s1.length() && r<s2.length()){
            if(s1.charAt(l)==s2.charAt(r)){
                l++;
                r++;
            }else{
                r++;
            }
        }

    return l==s1.length();
    }

    public int longestStrChain(String[] words) {
        int count=0;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(helper(words[j],words[i]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            count=Math.max(count,dp[i]);
        }

        return count;
    }
}