class Solution {
    public int trap(int[] height) {
        // create the prefix and suffix maximum vectors
        int n = height.length;
        int trappedWater = 0;
        
        int l = 0;
        int maxLeft = height[l];

        int r = n - 1;
        int maxRight = height[r];

        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                trappedWater += Math.max(maxLeft - height[l], 0);
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                trappedWater += Math.max(maxRight - height[r], 0);
            }
        }

        return trappedWater;
    }
}
