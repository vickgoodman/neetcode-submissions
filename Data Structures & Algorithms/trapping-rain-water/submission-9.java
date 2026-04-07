class Solution {
    public int trap(int[] height) {
        // create the prefix and suffix maximum vectors
        int n = height.length;
        int trappedWater = 0;
        
        int maxLeft = height[0];
        int l = 1;

        int maxRight = height[n - 1];
        int r = n - 2;

        while (l <= r) {
            if (maxLeft < maxRight) {
                trappedWater += Math.max(maxLeft - height[l], 0);
                maxLeft = Math.max(maxLeft, height[l]);
                l++;
            } else {
                trappedWater += Math.max(maxRight - height[r], 0);
                maxRight = Math.max(maxRight, height[r]);
                r--;
            }
        }

        return trappedWater;
    }
}
