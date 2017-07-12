/**
 * Created by Madyue on 2017/7/12.
 */

/**
 * 扫描两次数组
 * 第一次从左往右，记录（不包括）当前位置的左边的最大柱长
 * 第二次从右往左，记录（不包括）当前位置的右边的最大柱长，并与第一次记录的值对比，取较小的
 * 根据第二次的结果，计算面积
 * Time = O(n)
 */
public class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int[] dp = new int[length];
        int temp = 0;
        int rs = 0;
        for(int i = 0; i<length; i++){
            dp[i] = temp;
            temp = Math.max(height[i],temp);
        }
        temp = 0;
        for(int i = length-1; i>=0; i--){
            dp[i] = Math.min(dp[i],temp);
            temp = Math.max(height[i],temp);
            rs += dp[i] > height[i]? dp[i] - height[i]:0;
        }
        return rs;
    }
}
