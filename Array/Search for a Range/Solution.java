/**
 * Created by Madyue on 2017/7/11.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] rs = new int[2];
        int left = 0;
        int mid;
        int right = nums.length-1;
        while(left<=right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                int l = mid;
                int r = mid;
                while(l-1>=0 && nums[l-1] == nums[mid]){
                    l--;
                }
                while(r+1<nums.length && nums[r+1] == nums[mid]){
                    r++;
                }
                rs[0] = l;
                rs[1] = r;
                return rs;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        rs[0] = -1;
        rs[1] = -1;
        return rs;
    }

}