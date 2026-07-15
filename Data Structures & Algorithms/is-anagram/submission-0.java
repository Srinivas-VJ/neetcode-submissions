class Solution {
    public boolean isAnagram(String s, String t) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            w1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            w2[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(w1, w2);
    }
}
