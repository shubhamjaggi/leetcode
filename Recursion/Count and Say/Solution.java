class Solution {
    public String countAndSay(int n) {
        if (n==1) return "1";
        String val = String.valueOf(countAndSay(n-1));
        StringBuilder ans = new StringBuilder("");
        for(int i=0; i<val.length(); i++) {
            int count=1;
            while(i<(val.length()-1) && val.charAt(i)==val.charAt(i+1)) {
                count++; i++;
            }
            ans.append(String.valueOf(count)).append(val.charAt(i));
        }
        return ans.toString();
    }
}