/**
 * Created by Madyue on 2017/7/13.
 */

/**
 * 转换成数学问题,即一个点(x1,y1)绕另一个点(x0,y0)旋转a度，求旋转之后的坐标
 * x = (x1-x0)cosa + (y1-y0)sina + x0;
 * y = (y1-y0)cosa - (x1-x0)sina + y0;
 * 当a = 90度时
 * x = y1
 * y = x0 + y0 - x1;
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for(int i = 0; i<n/2; i++){
            for(int j = 0; j<(n+1)/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
