package problems.archive.solutions;

class TrappingRainWaterSolution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            System.out.println("The input array is null or empty. No water can be trapped.");
            return 0;
        }

        int left = 0;
        int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;

        System.out.println("Initial State:");
        System.out.println("Height Array: " + java.util.Arrays.toString(height));
        System.out.println("Left Pointer: " + left + ", Right Pointer: " + right);
        System.out.println("MaxLeft: " + maxLeft + ", MaxRight: " + maxRight);
        System.out.println("==============================================");

        while (left < right) {
            if (height[left] < height[right]) {
                // Process left pointer
                System.out.println("Processing left at index " + left + " with height " + height[left]);
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                    System.out.println("New maxLeft set to " + maxLeft);
                } else {
                    int water = maxLeft - height[left];
                    totalWater += water;
                    System.out.println("Water trapped at index " + left + ": " + water);
                }
                left++; // Increment left pointer
                System.out.println("Moved left pointer to " + left);
            } else {
                // Process right pointer
                System.out.println("Processing right at index " + right + " with height " + height[right]);
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                    System.out.println("New maxRight set to " + maxRight);
                } else {
                    int water = maxRight - height[right];
                    totalWater += water;
                    System.out.println("Water trapped at index " + right + ": " + water);
                }
                right--; // Decrement right pointer
                System.out.println("Moved right pointer to " + right);
            }
            System.out.println("Current Total Water: " + totalWater);
            System.out.println("==============================================");
        }

        System.out.println("Final Total Water Trapped: " + totalWater);
        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWaterSolution solution = new TrappingRainWaterSolution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped Rain Water: " + solution.trap(height));
    }
}

