class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<numRows;i++){
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

        return ans;
    }
}