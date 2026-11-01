class Solution {
    private boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }

        return false;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            if (isOperation(token.charAt(0)) && token.length() == 1) {
                char op = token.charAt(0);
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;

                if (op == '+') {
                    res = num2 + num1;
                } else if (op == '-') {
                    res = num2 - num1;
                } else if (op == '/') {
                    res = num2 / num1;
                } else if (op == '*') {
                    res = num2 * num1;
                }

                stack.push(res);
            } else {
                int num = Integer.parseInt(token);

                stack.push(num);
            }
        }

        return stack.pop();
    }
}
