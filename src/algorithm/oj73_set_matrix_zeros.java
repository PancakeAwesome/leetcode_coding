/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;

/**题目: 
【题目】

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

【思路】
我直接看了下面的要求，最先想到的就是O(m+n)的空间，就是加一行一列来标记哪行哪列有0；反而是O(mn)的空间不知该怎么利用了。

接下来想O(1)空间，稍微一想，竟然想到了答案，就是相比用O(m+n)的空间，不额外加一行一列，就用第一行和第一列来存储哪行哪列有0。
当然，这样做比较麻烦的是第一行第一列的原始信息，需要先保存下来。
 * @author edward.guan
 *
 */

class Solution73 {
    public void setZeroes(int[][] matrix) {  
        int m = matrix.length;  
        int n = matrix[0].length;  
        int i, j;  
          
        //先标记第一行和第一列是否有0  
        boolean firstRow = false, firstCol = false;  
        for (j = 0; j < n; j++) {  
            if (0 == matrix[0][j]) {  
                firstRow = true;  
                break;  
            }  
        }  
        for (i = 0; i < m; i++) {  
            if (0 == matrix[i][0]) {  
                firstCol = true;  
                break;  
            }  
        }  
           
        //从第二行第二列还是遍历，如果遇到0，则把它所在行和列的第一个值设为0     
        for (i = 1; i < m; i++) {  
            for (j = 1; j < n; j++) {  
                if (0 == matrix[i][j]) {  
                    matrix[i][0] = 0;  
                    matrix[0][j] = 0;  
                }  
            }  
        }  
          
        //把第一列的0所在行都设为0，把第一行的0所在列都设为0  
        for (i = 1; i < m; i++) {  
            if (0 == matrix[i][0]) {  
                for (j = 1; j < n; j++) {  
                    matrix[i][j] = 0;  
                }  
            }  
        }  
        for (j = 1; j < n; j++) {  
            if (0 == matrix[0][j]) {  
                for (i = 1; i < m; i++) {  
                    matrix[i][j] = 0;  
                }  
            }  
        }  
          
        //根据标记决定第一行和第一列是否全设为0  
        if (firstRow) {  
            for (j = 0; j < n; j++) {  
                matrix[0][j] = 0;  
            }  
        }  
        if (firstCol) {  
            for (i = 0; i < m; i++) {  
                matrix[i][0] = 0;  
            }  
        }  
    }
}

public class oj73_set_matrix_zeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{0, 1, 2}, {3, 4, 5}};
		new Solution73().setZeroes(matrix);
	}

}
