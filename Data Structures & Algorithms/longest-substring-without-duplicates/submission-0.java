class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int res = 0;
        Set<Character> window = new HashSet<>();

        while (r < n) {
            while (l < r && window.contains(s.charAt(r))) {
                window.remove(s.charAt(l++));
            }
            window.add(s.charAt(r++));
            res = Math.max(res, window.size());
        }
        return res;
    }
}
