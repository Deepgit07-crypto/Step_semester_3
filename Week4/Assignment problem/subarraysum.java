import java.util.HashMap;
import java.util.Map;

public class subarraysum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        // Hash map to store prefix sum frequencies[cite: 9]
        // Key: prefix sum, Value: frequency of that prefix sum[cite: 9]
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: a prefix sum of 0 has occurred once (for subarrays starting at index 0)[cite: 9]
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in the map, it means there are prefix sums[cite: 9]
            // that, when subtracted from currentSum, give a subarray sum equal to k[cite: 9]
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Update the frequency of the current prefix sum in the map[cite: 9]
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}