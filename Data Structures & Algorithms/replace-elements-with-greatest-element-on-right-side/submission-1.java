class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxSoFar = -1;

        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(val, maxSoFar);
        }

        return arr;
    }
}