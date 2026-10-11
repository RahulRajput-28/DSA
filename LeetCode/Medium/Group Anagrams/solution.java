class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();

        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);

            String newStr=new String(ch);

            if(!map.containsKey(newStr)){
                map.put(newStr,new ArrayList<>());
            }

            map.get(newStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}