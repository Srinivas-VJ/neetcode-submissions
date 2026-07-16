class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        int l1 = s.length(), l2 = t.length();

        while (p2 < l2) {
            while (p1 < l1 && p2 < l2 && s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            }
            p2++;
        }

        return p1 == l1;
    }
}