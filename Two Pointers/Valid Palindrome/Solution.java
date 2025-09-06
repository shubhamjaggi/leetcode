class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();

        int start=0;
        int end=n-1;

        s=s.toLowerCase();

        while(start<end) {
            while(start<end && !isAlphanumeric(s.charAt(start))) start++;
            while(start<end && !isAlphanumeric(s.charAt(end))) end--;
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        
        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return (ch>='a' && ch<='z') || (ch>='0' && ch<='9');
    }
}