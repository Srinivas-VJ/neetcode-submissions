class Solution {
    public int lengthOfLastWord(String s) {
        List<Character> word = new ArrayList<>();
        int lastWordLen = 0;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (word.size() > 0) {
                    lastWordLen = word.size();
                }
                word.clear();
            } else {
                word.add(ch);
            }
        }
        if (word.size() > 0) {
            return word.size();
        }

        return lastWordLen;
    }
}