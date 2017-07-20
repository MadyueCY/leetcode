/**
 * Created by Madyue on 2017/7/20.
 */

/**
 * 贪心大法好
 * 每一次都维护一个最远步数
 * Time = o(n)
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0)
            return false;
        int maxReach = nums[0];
        int length = nums.length;
        for(int i = 0; i<=maxReach&&i<length; i++){
            maxReach = Math.max(maxReach,nums[i]+i);
        }
        if(maxReach >= length-1){
            return true;
        }else{
            return false;
        }

    }
}