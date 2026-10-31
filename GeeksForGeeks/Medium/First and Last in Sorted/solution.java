class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int start=-1,end=-1;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                start=i;
                break;
            }
        }
        
        if(start!=-1){
            for(int i=start;i<arr.length;i++){
            if(arr[i]!=x){
                end=i-1;
                break;
            }
            }
            
            if(end==-1){
                end=arr.length-1;
            }
        }
        
        
        ArrayList<Integer> li=new ArrayList<>();
        
        li.add(start);
        li.add(end);
        
        return li;
        
    }
}
