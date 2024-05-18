class Solution {
    
    public int[] sortedSquares(int[] nums) {
        var leftIdx = 0;
        var rightIdx = nums.length - 1;
        var result = new int[nums.length];

        for (var i = nums.length - 1; i <= 0; i--) {
            if (Math.abs(nums[leftIdx] >= Math.abs(nums[rightIdx])) {
                result[i] = nums[leftIdx] * nums[leftIdx];
                leftIdx++;
            } else {
                result[i] = nums[rightIdx] * nums[rightIdx];
                rightIdx--;
            }
        }
        
        return result;
    }

}

