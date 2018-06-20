package algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *题目：Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

思路：
递归加括号，先加左括号，三种边界条件。
注意左括号数量大于右括号。
 * @author edward.guan
 *
 */

class Solution22 {
    public ArrayList<String> generateParenthesis(int n) {  
        ArrayList<String> list = new ArrayList<String>();  
        rec(n, 0, 0, "", list);  
        return list;  
    }  
      
    public void rec(int n, int left, int right, String s, ArrayList<String> list){  
        // invariant必须满足左括号数目要大等于右括号数目  
        if(left < right){  
            return;  
        }  
          
        // 如果左右括号数目相等则添加到list  
        if(left==n && right==n){  
            list.add(s);  
            return;  
        }  
          
        // 左括号已满，只能添加右括号  
        if(left == n){  
            rec(n, left, right+1, s+")", list);  
            return;  
        }  
          
        rec(n, left+1, right, s+"(", list);     // 继续添加左括号  
        rec(n, left, right+1, s+")", list);     // 继续添加右括号  
    }  
}

public class oj22_generate_parentheses {
	public static void main(String[] args) throws IOException {
		int n = 9;
        System.out.println(new Solution22().generateParenthesis(n));
    }
}
