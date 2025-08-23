class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length; int n=matrix[0].length;
        int start=0; int end=(m*n)-1;
        while(start<=end) {
            int mid=(start+end)/2;
            int midVal=matrix[getI(mid,n)][getJ(mid,n)];
            if(midVal==target) return true;
            else if(midVal<target) start=mid+1;
            else end=mid-1;
        }
        return false;
    }

    private int getI(int idx, int totCols) {
        return idx/totCols;
    }

    private int getJ(int idx, int totCols) {
        return idx%totCols;
    }
}