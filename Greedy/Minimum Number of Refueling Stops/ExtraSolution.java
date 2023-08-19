class ExtraSolution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<int[]> stationQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1], Comparator.reverseOrder()));
        int currFuelStationIndex = 0;
        int maxDistance = startFuel;
        int min = 0;

        while(maxDistance < target) {
            while(currFuelStationIndex < stations.length && stations[currFuelStationIndex][0] <= maxDistance) stationQueue.offer(stations[currFuelStationIndex++]);
            if(stationQueue.isEmpty()) return -1;
            maxDistance += stationQueue.poll()[1];
            min ++;
        }

        return min;
    }
}