public class duplicate {
    public boolean containsDuplicate(int[] nums) {
        // Using two nested loops to check every pair of distinct positions (i, j)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If any two different positions hold the exact same value, return true immediately
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        
        // Return false if no duplicate values are found after checking all pairs
        return false;
    }
}
