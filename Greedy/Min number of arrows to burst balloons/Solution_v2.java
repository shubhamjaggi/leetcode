class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points, (a,b) -> Integer.compare(b[0],a[0]));

        Integer lastArrowPos=points[0][0];
        int arrows=1;

        for(int i=1; i<points.length; i++) {
            if(points[i][1]<lastArrowPos) {
                arrows++;
                lastArrowPos=points[i][0];
            }
        }

        return arrows;
    }
}