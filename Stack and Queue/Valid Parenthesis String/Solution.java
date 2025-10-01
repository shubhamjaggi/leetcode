class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') openBrackets.push(i);
            else if(s.charAt(i) == '*') stars.push(i);
            else {
                if(openBrackets.isEmpty()) {
                    if(stars.isEmpty()) return false;
                    else stars.pop();
                }
                else openBrackets.pop();
            }
        }

        while(!openBrackets.isEmpty()) {
            if(stars.isEmpty()) return false;
            if(openBrackets.pop() > stars.pop()) return false;
        }

        return openBrackets.isEmpty();
    }
}