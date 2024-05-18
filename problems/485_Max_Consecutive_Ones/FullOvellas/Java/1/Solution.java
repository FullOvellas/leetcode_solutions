class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        var max = 0;
        var current = 0;

        for (var num : nums) {
            if (num == 0) {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
            current += num;
        }

        if (current > max) {
            return current;
        }
        return max;
    }
}
