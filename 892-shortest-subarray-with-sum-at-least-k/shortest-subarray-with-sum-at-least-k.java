import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // Use long to prevent integer overflow during accumulation
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Monotonic deque storing indices of the prefixSum array
        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Rule 1: Check if we have a valid subarray sum >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Rule 2: Maintain the monotonic increasing property of the deque
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index to the deque
            deque.addLast(i);
        }

        // If minLength was never updated, return -1
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
}