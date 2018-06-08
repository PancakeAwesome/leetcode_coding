/**
 * 
 */
package algorithm;

/**题目： 
Implement strStr(). 
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

翻译： 
实现一个方法strStr()。返回字符串needle第一次在字符串haystack出现的下标，如果needle不是haystack的一部分，就返回-1。

分析： 
在文本中查找某个模式出现的位置的算法，称为字符串匹配算法。常用的方法有朴素字符串匹配算法、KMP算法等。
朴素字符串匹配算法，就是把2个字符串头部对齐，然后needle对字符串匹配，失配后，把haystack右移一位，继续从头匹配。我们这里采用朴素算法。
 * @author edward.guan
 *
 */
class Solution28 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }else if(needle.length() > haystack.length()) {
            return -1;
        }
        
        int l2 = needle.length();
        int therehold = haystack.length() - l2;
        
        for(int i = 0; i <= therehold; i++) {
//             每次寻找匹配字符串中相同长度的字符串
            if(haystack.substring(i, i + l2).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}

public class oj28_Implement_strStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hello";
		String s2 = "lo";
        System.out.println(new Solution28().strStr(s1, s2));
	}

}
