class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Interval> sortedInts = Arrays.stream(intervals)
            .map(a -> new Interval(a[0], a[1]))
            .sorted(Comparator.comparing(Interval::getEnd))
            .collect(Collectors.toList());

        int countRemoval = 0;
        int currEnd = sortedInts.get(0).end;
        
        for(int i=0; i<intervals.length-1; i++) {
            if(currEnd > sortedInts.get(i+1).start) {
                countRemoval++;
            } else {
                currEnd = sortedInts.get(i+1).end;
            }
        }

        return countRemoval;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() { return this.end; }
}