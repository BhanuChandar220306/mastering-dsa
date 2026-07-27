class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }
        int res = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBloom(bloomDay, mid, m, k)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public boolean isBloom(int arr[], int mid, int m, int k) {
        int count = 0;
        int boquet = 0;
        for (int x : arr) {
            if (x <= mid) {
                count++;
                if (count == k)
                {
                    boquet++;
                    count=0;
                }
            } else {
                count = 0;
            }
        }
        return boquet >= m;
    }
}