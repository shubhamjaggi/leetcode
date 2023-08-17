class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Queue<BoxConfig> boxConfigs = new PriorityQueue<>(Comparator.comparing(BoxConfig :: getNumOfUnits).reversed());
        IntStream.range(0, boxTypes.length).forEach(i -> {
            boxConfigs.offer(new BoxConfig(boxTypes[i][0], boxTypes[i][1]));
        });

        int totalUnits = 0;
        int newTruckSize = truckSize;

        while(!boxConfigs.isEmpty() && newTruckSize >= boxConfigs.peek().getNumOfBoxes()) {
            totalUnits += boxConfigs.peek().getNumOfBoxes() * boxConfigs.peek().getNumOfUnits();
            newTruckSize -= boxConfigs.poll().getNumOfBoxes();
        }

        if(!boxConfigs.isEmpty() && newTruckSize > 0){
            totalUnits += (newTruckSize * boxConfigs.peek().getNumOfUnits());
        }

        return totalUnits;
    }

}

class BoxConfig {
    private int numOfBoxes;
    private int numOfUnits;

    BoxConfig(int numOfBoxes, int numOfUnits){
        this.numOfBoxes = numOfBoxes;
        this.numOfUnits = numOfUnits;
    }

    public int getNumOfBoxes(){
        return this.numOfBoxes;
    }

    public int getNumOfUnits(){
        return this.numOfUnits;
    }
}