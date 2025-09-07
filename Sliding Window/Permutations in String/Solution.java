class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length(), n=s2.length();
        if(m>n) return false; // handle edge case

        Map<Character,Integer> s1CountMap = new HashMap<>();
        Map<Character,Integer> s2CountMap = new HashMap<>();

        for(char ch='a'; ch<='z'; ch++) {
            s1CountMap.put(ch,0);
            s2CountMap.put(ch,0);
        }

        for(int i=0; i<m; i++) {
            char s1Char=s1.charAt(i);
            s1CountMap.put(s1Char, s1CountMap.get(s1Char)+1);
        }

        for(int i=0; i<m; i++) { // initialise first sliding window (of length m) in s2
            char s2Char=s2.charAt(i);
            s2CountMap.put(s2Char, s2CountMap.get(s2Char)+1);
        }

        int matches=0;
        for(char ch='a'; ch<='z'; ch++) {
            if(s1CountMap.get(ch).intValue()==s2CountMap.get(ch).intValue()) matches++;
        }

        if(matches==26) return true;

        int left=0;
        int right=left+m-1;

        while(right<n-1) {
            char toBeRemoved=s2.charAt(left);
            char toBeAdded=s2.charAt(right+1);
            left++; right++; // slide window

            if(toBeRemoved!=toBeAdded) {
                int prevFreqRemoval=s2CountMap.get(toBeRemoved);
                int prevFreqAddition=s2CountMap.get(toBeAdded);

                s2CountMap.put(toBeRemoved, prevFreqRemoval-1);
                if(s1CountMap.get(toBeRemoved).intValue()==s2CountMap.get(toBeRemoved).intValue()) {
                    matches++;
                } else if(s1CountMap.get(toBeRemoved).intValue()==prevFreqRemoval) {
                    matches--;
                }

                s2CountMap.put(toBeAdded, prevFreqAddition+1);
                if(s1CountMap.get(toBeAdded).intValue()==s2CountMap.get(toBeAdded).intValue()) {
                    matches++;
                } else if(s1CountMap.get(toBeAdded).intValue()==prevFreqAddition) {
                    matches--;
                }
            }

            if(matches==26) return true;
        }

        return false;
    }
}