class Solution {
    public int trap(int[] height) {
        // create the prefix and suffix maximum vectors
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            if (height[i] > prefix[i - 1]) {
                prefix[i] = height[i];
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > suffix[i + 1]) {
                suffix[i] = height[i];
            } else {
                suffix[i] = suffix[i + 1];
            }
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += (Math.min(prefix[i], suffix[i]) - height[i]);
        }

        return trappedWater;
    }
}
