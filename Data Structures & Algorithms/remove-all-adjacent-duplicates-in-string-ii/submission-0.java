class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{s.charAt(i), 1});
            } else {
                int[] top = stack.pop();

                if (top[0] == s.charAt(i)) {
                    stack.push(new int[]{top[0], top[1] + 1});
                } else {
                    stack.push(top);
                    stack.push(new int[]{s.charAt(i), 1});
                }

                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            
            for (int count = 0; count < top[1]; count++) {
                sb.append((char) top[0]);
            }
        }

        sb = sb.reverse();

        return sb.toString();
    }
}