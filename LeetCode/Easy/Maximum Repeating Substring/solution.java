class Solution {
    public int maxRepeating(String sequence, String word) {
        int count=0;
        StringBuilder st=new StringBuilder();

        while(sequence.contains(st.toString())){
            count++;
            st.append(word);
        }

        return count-1;
    }
}