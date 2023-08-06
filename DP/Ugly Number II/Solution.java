class Solution {

    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;

        int uglyNums[] = new int[n+1];
        uglyNums[1] = 1;

        for(int i=2; i<=n; i++){
            int val2 = 2 * uglyNums[i2 + 1];
            int val3 = 3 * uglyNums[i3 + 1];
            int val5 = 5 * uglyNums[i5 + 1];
            uglyNums[i] = min(val2, val3, val5);
            if(i == n){
                break;
            }
            i2 = uglyNums[i] == val2 ? i2+1 : i2;
            i3 = uglyNums[i] == val3 ? i3+1 : i3;
            i5 = uglyNums[i] == val5 ? i5+1 : i5;
        }
        return uglyNums[n];
    }

    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}