/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * @author edward.guan
 *
有大神提出了另一种方案，不需要构造邻接矩阵，思路就是将字符串中的每一个位置用‘a’~‘z’都都换一次，
然后在查看这个字符串是否在字典里，这样就等于找到了所有字典中与原字符串相差为1的字符串。然后就是利用BFS的思想搜索。
 */

class Solution127 {  
    public int ladderLength(String start, String end, List<String> dict) {
        if(!dict.contains(end)) return 0;
        if (start == null || end == null || start.equals(end))    
            return 0;    
    
        if (isOneWordDiff(start, end))    
            return 2;    
    
        Queue<String> queue=new LinkedList<String>();//访问队列    
        Set<String> visited = new HashSet<String>();//表示字典里的对应key访问过了    
        int level = 0;//某一层的元素数  
        int len = 0;  
        //将能够进行一次转换就到字典里的string加到队列，也就是离start最近的  
        StringBuilder sb = new StringBuilder(start);//重复修改字符串并且是单线程使用StringBuilder  
        for(int i = 0 ; i < start.length(); i++){  
            char tmp = sb.charAt(i);  
            for(char j = 'a' ; j <= 'z' ; j ++){  
                if(j == tmp){  
                    continue;  
                }else{  
                    sb.setCharAt(i,j);  
                    if(dict.contains(sb.toString())){  
                        queue.offer(sb.toString());  
                        level ++;  
                        visited.add(sb.toString());  
                    }  
                }  
            }  
            sb.setCharAt(i,tmp);  
        }  
        while(!queue.isEmpty())    
        {    
            len++;  
            int count = 0;  
            int nextLevel = 0;  
            while(count < level){//控制出队的个数  
                String tmp = queue.poll();  
                if(isOneWordDiff(tmp,end)){  
                    return len + 2;  
                }else{  
                    sb = new StringBuilder(tmp);  
                    for(int i = 0 ; i < tmp.length(); i++){  
                        char c = sb.charAt(i);  
                        for(char j = 'a' ; j <= 'z' ; j ++){  
                            if(j == c){  
                                continue;  
                            }else{  
                                sb.setCharAt(i,j);  
                                if(dict.contains(sb.toString()) && !visited.contains(sb.toString())){  
                                    queue.offer(sb.toString());  
                                    nextLevel ++;  
                                    visited.add(sb.toString());  
                                }  
                            }  
                        }  
                        sb.setCharAt(i,c);  
                    }  
                }  
                count++;  
            }  
            level = nextLevel;  
        }  
        return 0;    
    }  
    private boolean isOneWordDiff(String a, String b) {    
        int diff = 0;    
        for (int i = 0; i < a.length(); i++) {    
            if (a.charAt(i) != b.charAt(i)) {    
                diff++;    
                if (diff >= 2)    
                    break;    
            }    
        }    
        return diff == 1;    
    }  
} 

public class oj127_word_ladder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String end = "cog";
		String[] arr = new String[]{"hot","dot","dog","lot","log","cog"};
		List<String> dict = Arrays.asList(arr);
		System.out.println(new Solution127().ladderLength(begin, end, dict));
	}

}
