class Solution {
    public void duplicateZeros(int[] arr) {
        for (var i = 0; i < arr.legth; i++) {
            if (arr[i] != 0) {
                continue;
            }

            this.copyFrom(i, arr);
            i++;
        }
    }

    private void copyFrom(int index, int[] arr) {
        var prev = arr[index];
        for (var i = index + 1; i < arr.length; i++) {
            var aux = arr[i];
            arr[i] = prev;
            prev = aux;
        }
    }
}
