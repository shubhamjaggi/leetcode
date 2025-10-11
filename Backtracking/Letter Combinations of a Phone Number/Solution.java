class Solution {
    private static Map<Character,List<Character>> buttons=new HashMap<>();
    static {
        buttons.put('2', Arrays.asList('a','b','c'));
        buttons.put('3', Arrays.asList('d','e','f'));
        buttons.put('4', Arrays.asList('g','h','i'));
        buttons.put('5', Arrays.asList('j','k','l'));
        buttons.put('6', Arrays.asList('m','n','o'));
        buttons.put('7', Arrays.asList('p','q','r','s'));
        buttons.put('8', Arrays.asList('t','u','v'));
        buttons.put('9', Arrays.asList('w','x','y','z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.isEmpty()) return res;
        recurse(digits, 0, new char[digits.length()], res);
        return res;
    }

    private void recurse(String digits, int i, char[] comb, List<String> res) {
        if(i==digits.length()) {
            res.add(String.valueOf(comb));
            return;
        }
        for(char letter:buttons.get(digits.charAt(i))) {
            comb[i]=letter; // implicit backtracking
            recurse(digits, i+1, comb, res);
        }
    }
}