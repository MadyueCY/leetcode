/**
 * Created by Madyue on 2017/7/10.
 */

/**
 * 1. 先找偏移量
 * 2. 利用二分查找找位置
 * Time=O(log(n))
 */
public class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length==0)
            return -1;
        //先找偏移量
        int pivot = findth(nums,0,length-1);
        //二分查找
        int left = 0;
        int right = length-1;
        int mid,realMid;
        while(left<=right){
            mid = (left+right)/2;
            realMid = (pivot+mid)%length;
            if(nums[realMid] == target){
                return realMid;
            }
            else if(nums[realMid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
    //返回偏移量
    public int findth(int[] nums,int left,int right){
        if(left == right){
            return left;
        }
        int mid = (left+right)/2;
        if(nums[mid]>nums[right]){
            left = mid+1;
        }
        else{
            right = mid;
        }
        return findth(nums,left,right);
    }
}
