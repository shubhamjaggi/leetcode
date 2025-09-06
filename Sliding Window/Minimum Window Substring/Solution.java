class Solution {
    public String minWindow(String s, String t) {
        int m=s.length(), n=t.length();
        if(n==0 || m<n) return ""; // handle edge cases

        // create a count map and fill it with t's characters
        Map<Character,Integer> countMap=new HashMap<>();
        for(char ch:t.toCharArray()) countMap.put(ch, countMap.getOrDefault(ch,0)+1);

        /*
            Note: We'll follow the following rules for the countMap:
            - Removal of the character from the current window => Add occurrence to the countMap
            - Inclusion of the character in the current window => Remove occurrence from the countMap
        */

        // two pointers for sliding window
        int l=0, r=0;

        // this variable keeps a track of the number of t's characters accounted for in the current window
        int count=0;
        
        // these two variables represent starting index and the length of the solution respectively
        // they will ultimately be used to return the answer using s.substring(startInd,startInd+ansLength)
        int startInd=0, ansLength=m+1;

        // start a loop to traverse all the characters with the 'right' pointer
        while(r<m) {
            char rightCh=s.charAt(r);
            if(countMap.getOrDefault(rightCh,0)>0) { // t's character found at the 'right' pointer
                // account for the match by incrementing count and removing an occurrence from countMap
                count++;
                countMap.put(rightCh, countMap.getOrDefault(rightCh,0)-1);

                while(count==n) {
                    /*  count==n => A valid window has been found.
                        A window is only considered valid if it has all the t's characters. */
                    if(r-l+1 < ansLength) {
                        /* The current valid window has a smaller size that the earlier recorded size/default size.
                           Update the ansLength and startInd. */
                        ansLength=r-l+1;
                        startInd=l;
                    }
                    
                    /*  
                        Shrink the window from left as we are aiming
                        to get a better answer (i.e. smaller answer substring)
                        in the next iteration.
                    */
                    char leftCh=s.charAt(l); // character at left pointer to be removed from the current valid window

                    // removal of the character from the current window => adding the occurrence to the countMap
                    countMap.put(leftCh, countMap.getOrDefault(leftCh,0)+1);
                    if(countMap.get(leftCh)>0) count--; // This will only be true, if we are removing a t's character.
                    l++; // move the 'left' pointer forward
                }
            } else { // t's character not found at the 'right' pointer

                // inclusion of the character in the current window => remove the occurrence from the countMap
                countMap.put(rightCh, countMap.getOrDefault(rightCh,0)-1);
            }
            r++; // move the 'right' pointer forward
        }

        // if ansLength is still holding a default value, return empty string
        // otherwise return the answer by getting the required substring
        return ansLength==(m+1) ? "" : s.substring(startInd,startInd+ansLength);
    }
}