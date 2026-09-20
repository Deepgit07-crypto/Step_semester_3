public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Iterate through all possible pairs (i, j) using nested loops
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the current pair adds up to the target
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        
        // Return an empty array if no solution is found (guaranteed to have one per prompt)
        return new int[] {};
    }
}