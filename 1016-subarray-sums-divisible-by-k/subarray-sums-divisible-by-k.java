class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        int rem = 0;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = (sum % k + k) % k;
            if (hmap.containsKey(rem)) {
                ans += hmap.get(rem);
            }
            hmap.put(rem, hmap.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }
}