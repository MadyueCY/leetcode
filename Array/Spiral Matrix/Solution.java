import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madyue on 2017/7/20.
 */

/**
 * 方法1
 * 这个方法比较好理解，就是m,n分别记录行和列的当前位置
 * count记录步数，flag标识上下左右
 * 但是代码比较长，而且临近情况判断要小心
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return rs;

        int row = matrix.length;
        int col = matrix[0].length;
        int l = row*col;
        int flag = 0;
        int count = 0;
        int m = 0;
        int n = 0;
        int i = 0;
        while(count<l){
            switch(flag){
                case 0:{
                    for(i = 0; i < col; i++,count++){
                        rs.add(matrix[m][n+i]);
                    }
                    flag = 1;
                    n = n+i-1;
                    m++;
                    row --;
                }break;

                case 1:{
                    for(i = 0; i < row; i++,count++){
                        rs.add(matrix[m+i][n]);
                    }
                    flag = 2;
                    m = m + i-1;
                    n--;
                    col--;
                }break;

                case 2:{
                    for(i = 0; i < col; i++,count++){
                        rs.add(matrix[m][n-i]);
                    }
                    flag = 3;
                    n = n - i+1;
                    m--;
                    row --;
                }break;

                case 3:{
                    for (i = 0; i<row; i++,count++){
                        rs.add(matrix[m-i][n]);
                    }
                    flag = 0;
                    m = m - i+1;
                    n++;
                    col -- ;
                }break;

                default: break;

            }
        }
        return rs;
    }
}

/**
 * 方法2 来自于discuss
 * 很简单很精辟
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
}