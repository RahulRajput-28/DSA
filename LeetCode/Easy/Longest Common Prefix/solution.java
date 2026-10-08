class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str=strs[0];
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || str.charAt(i)!=strs[j].charAt(i)){
                    return ans.toString();
                }
            }
            ans.append(str.charAt(i));
        }

        return ans.toString();
    }
}