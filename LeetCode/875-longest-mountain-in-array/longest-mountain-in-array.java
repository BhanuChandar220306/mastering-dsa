class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 1; i <= n - 2; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }
                int right = i + 1;
                while (right < n - 1 && arr[right + 1] < arr[right]) {
                    right++;
                }
                int currentMountainLength = right - left + 1;
                maxLength = Math.max(maxLength, currentMountainLength);
                i = right;
            }
        }
        
        return maxLength;
    }
}