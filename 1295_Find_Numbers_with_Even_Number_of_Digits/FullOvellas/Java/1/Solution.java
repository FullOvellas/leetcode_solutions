class Solution {
    public int findNumbers(int[] nums) {
        var result = 0;

        for (var num : nums) {
            var digits = 0;

            while (num > 0) {
                digits++;
                num /= 10;
            }

            if (digits % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}
