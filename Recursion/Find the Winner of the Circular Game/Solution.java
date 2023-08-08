class Solution {

    public int findTheWinner(int n, int k) {
        return getWinner(n, k) + 1;
    }

    public int getWinner(int n, int k) {
        if(n == 1) return 0;
        return (getWinner(n-1, k) + k) % n;
    }
}