package algorithm;

import java.io.IOException;

/**
 * // 题目： 
// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

// 翻译： 
// 实现一个atoi函数来把字符串转换为整型变量。

// 分析： 
// 这道题的AC率只有13.4%，主要是因为对特殊情况的处理上。具体有这么几种情况需要考虑： 
// 1. 前面的空格 
// 2. 除去前面的空格后，可以以“+、-、0”开头，需要做对应的处理 
// 3. 除了起始处可以出现前2种情况提到的非数字字符，其他地方一旦出现，则忽略该字符以及其后的字符 
// 4. 考虑边界，即是否超出Integer.MAX_VALUE，Integer.MIN_VALUE。下面的方案采用long作为临时存储，方便做边界的判断。但是还要考虑是否会超出long的最大值，所以笔者采用length长度做初步判断。
 * @author edward.guan
 *
 */

class Solution8 {
    public int myAtoi(String str) {  
        // 1. null or empty string  
        if (str == null || str.length() == 0) return 0;  
          
        // 2. whitespaces  
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
          
        // 3. +/- sign  
        boolean positive = true;  
        int i = 0;  
        if (str.charAt(0) == '+') {  
            i++;  
        } else if (str.charAt(0) == '-') {  
            positive = false;  
            i++;  
        }  
          
        // 4. calculate real value  
        double tmp = 0;
        //用double类型比较Integer的最大值和最小值
        for ( ; i < str.length(); i++) {  
            int digit = str.charAt(i) - '0';  
              
            if (digit < 0 || digit > 9) break;  
              
            // 5. handle min & max  
            if (positive) {  
                tmp = 10*tmp + digit;  
                if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;  
            } else {  
                tmp = 10*tmp - digit;  
                if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;  
            }  
        }  
          
        int ret = (int)tmp;  
        return ret;  
    } 
}

public class oj8_string2int_atoi {
	public static void main(String[] args) throws IOException {
		
    	// System.out.println(str.charAt(str.length() - 1));
        String str = " ";
        System.out.println(new Solution8().myAtoi(str));
       
    }
}
