class Solution {
    private boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char bracket = stack.pop();

                    switch (bracket) {
                        case '(':
                            if (c == ']' || c == '}') {
                                return false;
                            }
                            
                            break;

                        case '[':
                            if (c == ')' || c == '}') {
                                return false;
                            }
                            
                            break;

                        case '{':
                            if (c == ')' || c == ']') {
                                return false;
                            }

                            break;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
