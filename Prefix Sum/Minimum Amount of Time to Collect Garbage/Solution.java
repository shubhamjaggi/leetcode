class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] prefix = new int[travel.length + 1];
        prefix[0] = 0;

        for(int i = 1; i <= travel.length; i++) {
            prefix[i] = prefix[i-1] + travel[i-1];
        }

        int pickingTime = 0;
        int maxIndM = -1;
        int maxIndP = -1;
        int maxIndG = -1;

        for(int i = 0; i < garbage.length; i++) {
            char[] chars = garbage[i].toCharArray();
            for(char c : chars) {
                if(c == 'M') maxIndM = i;
                else if(c == 'P') maxIndP = i;
                else if(c == 'G') maxIndG = i;
            }
            pickingTime += chars.length;
        }

        int travelTimeM = (maxIndM != -1 ? prefix[maxIndM] : 0);
        int travelTimeP = (maxIndP != -1 ? prefix[maxIndP] : 0);
        int travelTimeG = (maxIndG != -1 ? prefix[maxIndG] : 0);

        return travelTimeM + travelTimeP + travelTimeG + pickingTime;
    }
}