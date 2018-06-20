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
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
             
思路：
从高位开始两String逐位相加，使用StringBuilder可以加速字符串的处理，注意最后需要反转Stringbuilder（里面存的结果是逆序）。
 */

class Solution67 {
    public String addBinary(String a, String b) {  
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        int i = a.length() - 1, j = b.length() - 1;
        int fix = 0;//进位
        StringBuilder res = new StringBuilder();
        
        while(i >= 0 && j >= 0) {
            int tmp = (int)(a.charAt(i) - '0' + b.charAt(j) - '0' + fix);
            fix = tmp / 2;
            tmp %= 2;
            res.append(tmp);
            i--;
            j--;
        }
        
        while(i >= 0) {
            int tmp = (int)(a.charAt(i) - '0' + fix);
            fix = tmp / 2;
            tmp %= 2;
            res.append(tmp);
            i--;
        }
        
        while(j >= 0) {
            int tmp = (int)(b.charAt(j) - '0' + fix);
            fix = tmp / 2;
            tmp %= 2;
            res.append(tmp);
            j--;
        }
        
        if(fix != 0) {
            res.append(fix);
        }
        
        return res.reverse().toString();
    }  
}

public class oj67_add_binary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "10101", b = "10010";
		System.out.println(new Solution67().addBinary(a, b));
	}

}
