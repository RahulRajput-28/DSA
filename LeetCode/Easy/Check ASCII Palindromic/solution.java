class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder fbinary=new StringBuilder();

        for(int i=0;i<s.length();i++){
            int val=(int)s.charAt(i);
            String nbinary=Integer.toBinaryString(val);
            fbinary=fbinary.append("0").append(nbinary);
        }

        String finalbinary=fbinary.toString();
        int l=0;
        int r=finalbinary.length()-1;

        while(l<r){
            if(finalbinary.charAt(l)!=finalbinary.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}