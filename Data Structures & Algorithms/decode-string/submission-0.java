class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < sb.length()) {
            int currChar = sb.charAt(i);

            if (currChar == '[') {
                stack.push(i);
            } else if (currChar == ']') {
                int open = stack.pop(); // index of '['
                int start = open;
                int end = i;

                while (start > 0 && Character.isDigit(sb.charAt(start - 1))) {
                    start--;
                }
                int k = Integer.parseInt(sb.substring(start, open));

                // build the 'repeat' String
                String repeat = sb.substring(open + 1, end);
                StringBuilder repeatSb = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    repeatSb.append(repeat);
                }

                repeat = repeatSb.toString();

                // delete the encoding
                sb.delete(start, end + 1);

                // insert the 'repeat' String
                sb.insert(start, repeat);

                // update 'i' index
                i = i - (end - start + 1) + repeat.length();
            }

            i++;
        }

        return sb.toString();
    }
}