/**
 * Created by Madyue on 2017/7/19.
 */

/**
 * 动态规划
 * 如果要考虑空间复杂度,那么数组a,b的大小可以改为2
 * Time = O(n)
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] a = new int[length];
        int[] b = new int[length];
        a[0] = b[0] = nums[0];
        for(int i = 1; i < length; i++){
            a[i] = Math.max(a[i-1]+nums[i],nums[i]);
            b[i] = Math.max(a[i],b[i-1]);
        }
        return b[length-1];
    }
}