class Solution {
    String s;
    String t;
    int n, m;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        n = s.length();
        m = t.length();

        int[] dp = new int[m + 1];
        dp[m] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            int[] prev = new int[m + 1];
            prev[m] = 1;
            for (int j = m - 1; j >= 0; j--) {
                int sequences = 0;
                sequences += dp[j];

                if (s.charAt(i) == t.charAt(j))
                    sequences += dp[j + 1]; 

                prev[j] = sequences;
            }
            dp = prev;
        }

        return dp[0];
    }
}
