impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        let mut curr_consec = 0;
        let mut max_consec = 0;

        
        for num in &nums {
            if *num == 0 {
                max_consec = max_consec.max(curr_consec);
                curr_consec = 0;
            } else {
                curr_consec += 1;
            }
        }
        
        max_consec.max(curr_consec)
    }
}
