class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();

                if (top == '(') {
                    if (c == ')') { continue; }

                    return false;
                } 
                
                if (top == '[') {
                    if (c == ']') { continue; }

                    return false;
                } 
                
                if (top == '{') {
                    if (c == '}') { continue; }

                    return false;
                }
            }
        }

        if (!stack.isEmpty()) { return false; }
        
        return true;
    }
}
