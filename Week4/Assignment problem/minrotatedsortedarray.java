public class minrotatedsortedarray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Modified binary search to find the minimum element in O(log n) time
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element, 
            // the minimum value must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, the minimum value is in the left half including mid
            else {
                right = mid;
            }
        }

        // Left pointer will converge on the minimum element
        return nums[left];
    }
}
