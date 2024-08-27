class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        int[][] x = new int[intervals.length][2];
        x[0] = intervals[0];
        int count = 1;

        for(int i = 1, j = 0; i < intervals.length; i++) {
            if (x[j][1] >= intervals[i][0]) x[j][1] = Math.max(x[j][1], intervals[i][1]);
            else {
                x[++j] = intervals[i];
                count++;
            }
        }

        int[][] ans = new int[count][2];
        while(count > 0) ans[count-1] = x[(count--)-1];

        return ans;
    }
}