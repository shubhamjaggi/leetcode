class Solution {
    public int canCompleteCircuit(int[] gasIn, int[] gasOut) {
        int start=0; int requiredGas=0; int gasBalance = 0;

        for(int i=0; i<gasIn.length; i++) {
            gasBalance += (gasIn[i]-gasOut[i]);
            if(gasBalance<0) {
                start=i+1;
                requiredGas-=gasBalance;
                gasBalance=0;
            }
        }

        if (gasBalance>=requiredGas) return start; else return -1;
    }
}