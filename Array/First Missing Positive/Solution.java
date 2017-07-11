/**
 * Created by Madyue on 2017/7/11.
 */

/**
 * Time = O(n);
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int i = 0;
        while(i<length){
            if(nums[i]>0 && nums[i]-1<length && nums[i] != (i+1) && nums[i] != nums[nums[i]-1]){
                //这个地方的交换必须要注意!!
                //必须先改变nums[nums[i]-1]的值。
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }
        for(int j = 0; j<length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return length+1;
    }
}
