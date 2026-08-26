class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0;
        int count=0;

        String ans="";

        for(int r=0;r<s.length();r++){
            if(s.charAt(r)=='1'){
                count++;
            }

            while(count==k){
                String ns=s.substring(l,r+1);

                if(ans=="" ||
                    ans.length()>ns.length()||
                    (ans.length()==ns.length() && ns.compareTo(ans)<0)){
                        ans=ns;
                }

                if(s.charAt(l)=='1'){
                    count--;
                }
                l++;
            }
        }

        return ans;
    }
}