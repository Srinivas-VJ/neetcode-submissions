class Solution {
    Integer dp[];
    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return solve(s, 0);
    }

    private int solve(String s, int i) {

        if (i == s.length())
            return 1;
        
        if (s.charAt(i) == '0')
            return 0;
        
        if (dp[i] != null)
            return dp[i];

        int ways = 0;

        // consume 1
        if (i + 1 <= s.length() && (i == s.length() - 1 || s.charAt(i + 1) != '0')) {
            ways += solve(s, i + 1);
        }

        // consume 2
         if (i + 2 <= s.length() && (i == s.length() - 2 || s.charAt(i + 2) != '0') && canTake2(s.substring(i, i + 2))) {
            ways += solve(s, i + 2);
        }

        return dp[i] = ways;
    }

    private boolean canTake2(String val) {
        return Integer.parseInt(val) < 27;
    }
}
