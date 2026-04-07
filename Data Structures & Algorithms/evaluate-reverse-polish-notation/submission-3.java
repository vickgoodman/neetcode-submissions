class Solution {
    private boolean isOperation(String s) {
        return s.equals("+")
            || s.equals("-")
            || s.equals("*")
            || s.equals("/");
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> expression = new ArrayDeque<>();

        for (String s : tokens) {
            if (!isOperation(s)) {
                expression.push(Integer.parseInt(s));
            } else {
                int secondNumber = expression.pop();
                int firstNumber = expression.pop();

                int result = -1;
                switch (s) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }

                expression.push(result);
            }
        }

        return expression.pop();
    }
}
