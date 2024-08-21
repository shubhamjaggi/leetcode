class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                vis[i] = true;
                if (canReach(arr, start, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canReach(int[] arr, int start, int target, boolean[] vis) {
        if (start == target) return true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == Math.abs(target - i) && !vis[i]) {
                vis[i] = true;
                if (canReach(arr, start, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}