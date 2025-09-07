class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> config=new Stack<>();

        for(int i=0; i<n; i++) {
            char curr=s.charAt(i);
            if(isOpen(curr)) {
                config.push(curr);
            } else {
                if(config.isEmpty()) return false;
                if(config.peek()==getOpening(curr)) {
                    config.pop();
                } else {
                    return false;
                }
            }
        }

        return config.isEmpty();
    }

    private boolean isOpen(char ch) {
        return (ch=='(' || ch=='[' || ch=='{');
    }

    private char getOpening(char ch) {
        if(ch==')') return '(';
        if(ch==']') return '[';
        if(ch=='}') return '{';
        return ' ';
    }
}