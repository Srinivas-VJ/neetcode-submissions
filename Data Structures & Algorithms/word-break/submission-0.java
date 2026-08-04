class Solution {
    Map<Integer, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict, 0);
    }

    private boolean solve(String s, List<String> words, int i) {
        if (cache.containsKey(i))
            return cache.get(i);

        if (i == s.length())
            return true;
        
        boolean solvable = false;

        for (var word : words) {
            if (s.startsWith(word, i)) {
                solvable |= solve(s, words, i + word.length());
                if (solvable)
                    break;
            }
        }
        cache.put(i, solvable);
        return solvable;
    }
}
