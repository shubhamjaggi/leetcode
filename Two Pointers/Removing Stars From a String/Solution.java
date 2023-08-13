class Solution {
    public String removeStars(String s) {
        int i = 0;
        int j = 0;

        char[] chars = s.toCharArray();

        while(j < s.length()){
            if (s.charAt(j) == '*'){
                i--;
            }
            else{
                chars[i] = s.charAt(j);
                i++;
            }

            j++;
        }

        return String.valueOf(chars).substring(0, i);
    }
}