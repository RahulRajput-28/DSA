class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int gasCount=0;
        int total=0;

        for(int i=0;i<gas.length;i++){
            gasCount=gasCount+gas[i]-cost[i];
            total+=gas[i]-cost[i];

            if(gasCount<0){
                gasCount=0;
                start=i+1;
            }
        }

        if(total<0){
            return -1;
        }

        return start;
    }
}