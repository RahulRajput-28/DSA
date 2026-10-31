class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder st=new StringBuilder();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        List<Map.Entry<Character,Integer>> li=new ArrayList<>(map.entrySet());

        li.sort((a,b)->b.getValue()-a.getValue());

        for(int i=0;i<li.size();i++){
            int k=0;
            while(k<li.get(i).getValue()){
                st.append(li.get(i).getKey());
                k++;
            }
        }

        return st.toString();
    }
}