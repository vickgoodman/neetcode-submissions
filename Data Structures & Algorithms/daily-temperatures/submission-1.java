class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] result = new int[n];

        Deque<List<Integer>> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek().get(0) < temperatures[i]) {
                List<Integer> top = stack.pop();
                int topIndex = top.get(1);

                result[topIndex] = i - topIndex;
            }

            stack.push(new ArrayList<>(Arrays.asList(temperatures[i], i)));
        }

        return result;
    }
}
