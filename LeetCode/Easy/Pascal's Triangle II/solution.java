class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            List<Integer> li=new ArrayList<>();

            li.add(1);

            for(int j=1;j<i;j++){
                int val=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                li.add(val);
            }

            if(i>0){
                li.add(1);
            }

            ans.add(li);
        }

        return ans.get(rowIndex);
    }
}