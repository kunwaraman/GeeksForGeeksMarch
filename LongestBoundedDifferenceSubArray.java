public class LongestBoundedDifferenceSubArray {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        int left = 0, right = 0, maxLen = 0, startIdx = 0;

        // Min-Heap (Natural Order)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Max-Heap (Reverse Order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (right < n) {
            // Add current element to heaps
            minHeap.add(arr[right]);
            maxHeap.add(arr[right]);

            // Maintain condition: max - min <= x
            while (!minHeap.isEmpty() && !maxHeap.isEmpty() && (maxHeap.peek() - minHeap.peek() > x)) {
                // Remove elements from left
                minHeap.remove(arr[left]);
                maxHeap.remove(arr[left]);
                left++; // Move the left pointer
            }

            // Update longest valid subarray
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;
            }
            right++; // Expand window
        }

        // Construct the longest valid subarray
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIdx; i < startIdx + maxLen; i++) {
            result.add(arr[i]);
        }
        return result;

    }
}
