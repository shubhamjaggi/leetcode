class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>(Comparator.comparing(Point::distSquare).reversed());
        for(int[] point:points) {
            pq.add(new Point(point[0], point[1]));
            if(pq.size()>k) pq.poll();
        }
        int res[][]=new int[k][2];
        int i=0;
        while(!pq.isEmpty()) {
            Point point=pq.poll();
            res[i][0]=point.x;
            res[i++][1]=point.y;
        }
        return res;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }

    long distSquare() {
        return x*x + y*y;
    }
}