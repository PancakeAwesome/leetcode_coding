/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author edward.guan
 *
题目
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.


思路
首先，学习一下罗马数字，参考罗马数字

罗马数字是最古老的数字表示方式，比阿拉伯数组早2000多年，起源于罗马

罗马数字有如下符号：

基本字符	I	V	X	L	C	D	M
对应阿拉伯数字	1	5	10	50	100	500	1000

计数规则：
相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
正常使用时，连续的数字重复不得超过三次
在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）

其次，罗马数字转阿拉伯数字规则（仅限于3999以内）：

从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
 */

class Solution13 {
    public int charToInt(char c) {
        int data = 0;

        switch (c) {
            case 'I':
                data = 1;
                break;
            case 'V':
                data = 5;
                break;
            case 'X':
                data = 10;
                break;
            case 'L':
                data = 50;
                break;
            case 'C':
                data = 100;
                break;
            case 'D':
                data = 500;
                break;
            case 'M':
                data = 1000;
                break;
        }

        return data;
    }

    public int romanToInt(String s) {
        int res = 0;
        res = charToInt(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++) {
            int pre = charToInt(s.charAt(i - 1));  
            int cur = charToInt(s.charAt(i)); 
            
            if(cur <= pre) {
//                 前一个数字大于后一个数字
                res += cur;
            }else {
//                 前一个数字小于后一个数字
                res = res - 2 * pre + cur;
            }
        }
        
        return res;
    }
}

public class oj102_binarytree_level_order {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String roman = "LIV";
		System.out.println(new Solution13().romanToInt(roman));
	}

}
