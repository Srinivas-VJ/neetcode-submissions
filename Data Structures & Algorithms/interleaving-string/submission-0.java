class Solution {
    String a, b, c;
    public boolean isInterleave(String s1, String s2, String s3) {
    int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
    if (n1 + n2 != n3) return false;

    boolean[][] dp = new boolean[n1 + 1][n2 + 1];
    dp[0][0] = true; // base case: two empty prefixes form an empty prefix of s3

    for (int i = 0; i <= n1; i++) {
        for (int j = 0; j <= n2; j++) {
            if (i == 0 && j == 0) continue; // already set

            boolean fromS1 = i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
            boolean fromS2 = j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];

            dp[i][j] = fromS1 || fromS2;
        }
    }
    return dp[n1][n2];
}

    private boolean solve(int i, int j, int k) {
        if (k == c.length()) 
            return true;

        boolean isInterleave = false;

        if (i == a.length()) {
            if (b.charAt(j) == c.charAt(k)) {
                isInterleave |= solve(i, j + 1, k + 1);
            } else {
                return false;
            }
        } else if (j == b.length()) {
            if (a.charAt(i) == c.charAt(k)) {
                isInterleave |= solve(i + 1, j, k + 1);
            } else {
                return false;
            }
        } else {
            if (b.charAt(j) == c.charAt(k)) {
                isInterleave |= solve(i, j + 1, k + 1);
            }
            if (a.charAt(i) == c.charAt(k)) {
                isInterleave |= solve(i + 1, j, k + 1);
            }
        }
        return isInterleave;
    }
}
