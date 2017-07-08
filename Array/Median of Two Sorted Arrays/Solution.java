/**
 * Created by Madyue on 2017/7/8.
 */


/**
 * 1. 类似二分查找，查找数组中第K个小的数
 * 2. 几个边界条件要考虑清楚
 * 3. Time=O(log(m + n))
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        if (length%2 == 1){
            return findK(nums1,0,nums2,0,length/2+1);
        }else{
            return (double) (findK(nums1,0,nums2,0,length/2+1)+findK(nums1,0,nums2,0,length/2))/2.0;
        }

    }

    public double findK(int a[], int aStart, int b[], int bStart, int k){
        if((a.length-aStart)>(b.length-bStart)){
            return findK(b,bStart,a,aStart,k);
        }
        if (aStart == a.length){
            return b[bStart+k-1];
        }
        if(k == 1){
            return Math.min(a[aStart],b[bStart]);
        }
        int flagA = Math.min(k/2,(a.length-aStart));
        int flagB = k - flagA;
        if(a[aStart+flagA-1] < b[bStart+flagB-1]){
            return findK(a,aStart+flagA,b,bStart,k-flagA);
        }
        else if(a[aStart+flagA-1] > b[bStart+flagB-1]){
            return findK(a,aStart,b,bStart+flagB,k-flagB);
        }else{
            return a[aStart+flagA-1];
        }
    }
}
