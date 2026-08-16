class Solution {
    boolean vowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                return true;
            }
        return false;
    }
    
    public String reverseVowels(String s) {
        char[] ch=s.toCharArray();
        int l=0;
        int r=ch.length-1;

        while(l<r){
            if(vowel(ch[l]) && vowel(ch[r])){
                char c=ch[l];
                ch[l]=ch[r];
                ch[r]=c;
                l++;
                r--;
            }else if(vowel(ch[l])){
                r--;
            }else if(vowel(ch[r])){
                l++;
            }else{
                l++;
                r--;
            }
        }

        return new String(ch);
    }
}