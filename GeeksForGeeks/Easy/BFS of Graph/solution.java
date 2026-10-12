class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        ArrayList<Integer> bfs=new ArrayList<>();
        int[] visited=new int[n];
        Queue<Integer> queue=new LinkedList<>();
        
        queue.add(0);
        visited[0]=1;
        
        while(!queue.isEmpty()){
            int num=queue.poll();
            bfs.add(num);
            
            for(int no:adj.get(num)){
                if(visited[no]!=1){
                    visited[no]=1;
                    queue.add(no);
                }
            }
        }
        
        return bfs;
    }
}