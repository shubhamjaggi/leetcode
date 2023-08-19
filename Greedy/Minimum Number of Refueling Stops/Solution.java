class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> stationQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int currFuelStationIndex = 0;
        int maxDistance = startFuel;
        int min = 0;

        while(maxDistance < target) {
            while(currFuelStationIndex < stations.length && stations[currFuelStationIndex][0] <= maxDistance) stationQueue.offer(stations[currFuelStationIndex++][1]);
            if(stationQueue.isEmpty()) return -1;
            maxDistance += stationQueue.poll();
            min ++;
        }

        return min;
    }
}