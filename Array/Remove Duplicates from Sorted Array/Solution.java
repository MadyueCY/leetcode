/**
 * Created by Madyue on 2017/7/10.
 */

/**
 * Time=O(log(n))
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int rs = 0;
        if (length == 0){
            return 0;
        }
        for(int i = 0; i<length; i++){
            if(nums[rs] != nums[i]){
                nums[++rs] = nums[i];
            }
        }
        return rs+1;
    }
}