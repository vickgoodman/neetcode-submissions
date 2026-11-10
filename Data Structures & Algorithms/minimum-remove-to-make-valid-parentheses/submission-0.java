class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<int[]> stack = new Stack<>();

        int i = 0;

        while (i < sb.length()) {
            int currChar = sb.charAt(i);

            if (currChar >= 'a' && currChar <= 'z') {
                i++;
                continue;
            }

            if (stack.isEmpty()) {
                if (currChar == '(') {
                    stack.push(new int[]{currChar, i});
                } else {
                    sb.deleteCharAt(i);
                    i--;
                }
            } else {
                if (currChar == '(') {
                    stack.push(new int[]{currChar, i});
                } else {
                    stack.pop();
                }
            }

            i++;
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();

            sb.deleteCharAt(top[1]);
        }

        return sb.toString();
    }
}