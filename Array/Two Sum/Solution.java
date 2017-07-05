import java.util.HashMap;
import java.util.Map;

/**
 * Created by Madyue on 2017/7/5.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] rs = new int[2];
        int len = nums.length;
        for(int i = 0; i<len; i++){
            if(map.containsKey(nums[i])){
                rs[0] = map.get(nums[i]);
                rs[1] = i;
                break;
            }
            map.put(target-nums[i],i);
        }
        return rs;
    }
}
