class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        build(ans, "", 0, 0, n);
        return ans;
    }

    private void build(List<String> ans, String curr, int open, int close, int n) {
        if (close == n) {
            ans.add(curr); return;
        }
        if (open < n) build(ans, curr + "(", open+1, close, n);
        if (close < open) build(ans, curr + ")", open, close+1, n);
    }
}