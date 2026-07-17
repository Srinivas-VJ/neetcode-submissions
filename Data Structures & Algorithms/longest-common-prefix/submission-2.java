class Solution {
    public String longestCommonPrefix(String[] strs) {
        int lenOfPrefix = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length() && j < lenOfPrefix; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    lenOfPrefix = j;
                    break;
                }
            }
            lenOfPrefix = Math.min(lenOfPrefix, strs[i].length());
        }

        if (lenOfPrefix == 0) {
            return "";
        }

        return strs[0].substring(0, lenOfPrefix);
    }
}