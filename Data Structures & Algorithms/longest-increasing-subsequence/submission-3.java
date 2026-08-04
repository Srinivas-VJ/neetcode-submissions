class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (temp.isEmpty()) {
                temp.add(nums[i]);
            } else {
                if (nums[i] > temp.getLast()) {
                    temp.add(nums[i]);
                } else {
                    int idx = Collections.binarySearch(temp, nums[i]);
                    if (idx >= 0)
                        continue;
                    idx = -(idx) - 1;
                    temp.set(idx, nums[i]);
                }
            }
        }
        return temp.size();
    }
}
