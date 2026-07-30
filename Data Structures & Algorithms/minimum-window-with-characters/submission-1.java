class Solution {

    private boolean isValid(Map<Character, Integer> freqS, Map<Character, Integer> freqT) {
        for (var entry : freqT.entrySet()) {
            if (freqS.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        int n = s.length();
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();

        int[] indices = new int[]{0, 0};
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            freqT.merge(t.charAt(i), 1, Integer::sum);
        }

        while (r < n) {
            freqS.merge(s.charAt(r), 1, Integer::sum);

            while (isValid(freqS, freqT)) {
                if (r - l + 1 < minSize) {
                    minSize = r - l + 1;
                    indices = new int[]{l, r};
                }

                char leftChar = s.charAt(l);
                freqS.put(leftChar, freqS.get(leftChar) - 1);
                if (freqS.get(leftChar) == 0) {
                    freqS.remove(leftChar);
                }
                l++;
            }

            r++;
        }

        if (minSize == Integer.MAX_VALUE) return "";
        return s.substring(indices[0], indices[1] + 1);
    }
}