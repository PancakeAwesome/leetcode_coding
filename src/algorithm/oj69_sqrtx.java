/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author edward.guan
 *
题目： 
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
             
思路：
这道题一般采用数值中经常用的另一种方法：二分法。基本思路是跟二分查找类似，要求是知道结果的范围，取定左界和右界，然后每次砍掉不满足条件的一半，直到左界和右界相遇。
注意：判断当前数的平方是否符合要求，需要用结果除以当前数判断！
算法的时间复杂度是O(logx)，空间复杂度是O(1)。。
 */

class Solution69 {
    public int mySqrt(int x) {  
        //折半查找
        if(x == 0) return 0;
        int low = 1, high = x / 2 + 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(x / mid >= mid && x / (mid + 1) < (mid + 1)) {
                return mid;
            }
            if(x / mid < mid) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return -1;
    } 
}

public class oj69_sqrtx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 101;
		System.out.println(new Solution69().mySqrt(x));
	}

}
