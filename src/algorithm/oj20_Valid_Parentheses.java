/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;

/**题目： 
Given a string containing just the characters , determine if the input string is valid.

The brackets must close in the correct order, “()” and “()[]{}” are all valid but “(]” and “([)]” are not.

翻译： 
给定一个字符串，只包含’(‘, ‘)’, ‘{‘, ‘}’, ‘[’ 和’]’这些字符，检查它是否是“有效”的。 
括号必须以正确的顺序关闭，例如”()” 和”()[]{}”都是有效的，”(]” 和”([)]”是无效的。

分析： 
本题考查的是栈结构，具有后进先出的特性。有效包含2个方面，第一个是如果是关闭的括号，前一位一定要刚好有一个开启的括号；第二个是最终结果，需要把所有开启的括号都抵消完。一个比较容易出错的地方是，遇到关闭括号时，要先判断栈是否已经空了。
 * @author edward.guan
 *
 */

class Solution20 {
    public boolean isValid(String s) {
//         创建一个栈来顺序存放括号
        List<Character> stack = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
//             入栈
            if(c == '{' || c == '[' || c == '(') {
                stack.add(c);
            }else {
                if(c == '}') {
                    if(!stack.isEmpty() && stack.get(stack.size() - 1) == '{') {
//                    	有效包含2个方面，第一个是如果是关闭的括号，前一位一定要刚好有一个开启的括号；
//                    	第二个是最终结果，需要把所有开启的括号都抵消完。
//                    	一个比较容易出错的地方是，遇到关闭括号时，要先判断栈是否已经空了。
                        stack.remove(stack.size() - 1);
                    }else {
                        return false;
                    }
                }
                
                if(c == ']') {
                    if(!stack.isEmpty() && stack.get(stack.size() - 1) == '[') {
                        stack.remove(stack.size() - 1);
                    }else {
                        return false;
                    }
                }
                
                if(c == ')') {
                    if(!stack.isEmpty() && stack.get(stack.size() - 1) == '(') {
                        stack.remove(stack.size() - 1);
                    }else {
                        return false;
                    }
                }
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}

public class oj20_Valid_Parentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "{[()]}";
		String s = "()";
        System.out.println(new Solution20().isValid(s));
	}

}
