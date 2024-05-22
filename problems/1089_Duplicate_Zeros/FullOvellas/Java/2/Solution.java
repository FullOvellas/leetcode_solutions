class Solution {
    public void duplicateZeros(int[] arr) {
        var zeroes = 0;
        for (var num : arr) {
            if (num == 0) {
                zeroes++;
            }
        }

        var totalLen = arr.length + zeroes;
        for (int i = arr.length - 1, j = totalLen - 1; i >= 0; i--, j--) {
            if (arr[i] = 0) {
                if (j < arr.length) {
                    arr[j] = 0;
                }

                j--;
            }

            if (j < arr.length) {
                arr[j] = arr[i];
            }
        }
    }
}
