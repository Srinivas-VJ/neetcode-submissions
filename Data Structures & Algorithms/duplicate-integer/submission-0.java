class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        for (int v : nums) 
            if (!vals.add(v))
                return true;
        return false;
    }
}
