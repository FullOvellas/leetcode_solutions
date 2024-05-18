class Solution {
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).filter(num -> {
            var digits = 0;

            while (num > 0) {
                num /= 10;
                digits++;
            }

            return digits % 2 == 0;
        }).count();
    }
}
