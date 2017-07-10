import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Madyue on 2017/7/10.
 */

/**
 * 求三个数的和,可以先选定一个数然后转换为求两个数的和
 * 特别注意，，，要排除重复的组合!!!
 * Time=O(n^2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0; i<length-2; i++){
            //去重复
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            twoSum(nums,i+1,length-1,-(nums[i]),list);
        }
        return list;
    }

    public void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> list){
        while(left<right){
            int sum = nums[left] + nums[right] - target;
            if(sum == 0){
                List<Integer> l = new ArrayList<Integer>();
                l.add(-(target));
                l.add(nums[left]);
                l.add(nums[right]);
                list.add(l);
                left++;
                right --;
                //去重复
                while(left<right && nums[left] == nums[left-1]){
                    left ++;
                }
                while(left<right && nums[right] == nums[right+1]){
                    right--;
                }
            }else if(sum<0){
                left++;
            }else if(sum>0){
                right--;
            }
        }
    }
}
