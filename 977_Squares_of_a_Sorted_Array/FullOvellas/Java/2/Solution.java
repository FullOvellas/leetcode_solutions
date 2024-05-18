class Solution {

    public int[] sortedSquares(int[] nums) {
        for (var i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        this.sort(nums);
        return nums;
    }

    private void sort(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        boolean sorted;
        do {
            sorted = true;
            for (var i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    var temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);
    }

}
