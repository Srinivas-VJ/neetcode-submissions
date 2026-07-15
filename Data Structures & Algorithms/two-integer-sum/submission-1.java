class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = target - nums[i];
            if (indices.containsKey(val)) {
                return new int[]{indices.get(val), i};
            }
            if (!indices.containsKey(nums[i])) {
                indices.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
