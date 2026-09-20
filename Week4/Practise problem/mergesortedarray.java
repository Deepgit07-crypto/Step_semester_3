public class mergesortedarray {
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        // Create a new empty result array to hold all combined elements
        int[] result = new int[n1 + n2];
        
        // Pointers for arr1, arr2, and result array
        int i = 0;
        int j = 0;
        int k = 0;

        // Repeatedly compare elements and copy the smaller one into result
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy any remaining elements from arr1
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy any remaining elements from arr2
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}