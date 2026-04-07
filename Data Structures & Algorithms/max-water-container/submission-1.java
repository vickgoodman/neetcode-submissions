class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int maxArea = 0;

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);

            maxArea = Math.max(maxArea, area);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
