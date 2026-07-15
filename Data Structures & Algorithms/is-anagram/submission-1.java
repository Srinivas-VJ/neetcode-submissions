class Solution {
    public boolean isAnagram(String s, String t) {
        var charArr1 = buildFrequencyArr(s); 
        var charArr2 = buildFrequencyArr(t); 
        
        return Arrays.equals(charArr1, charArr2);
    }

    private int[] buildFrequencyArr(String s) {
        int[] freqArr = new int[26];
        for (char ch : s.toCharArray()) {
            freqArr[ch - 'a']++;
        }
        return freqArr;
    }
}
