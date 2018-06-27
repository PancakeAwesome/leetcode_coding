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
 * Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

思路：
这道题属于链表操作的题目，思路比较清晰，就是每次跳两个节点，后一个接到前面，前一个接到后一个的后面，
最后现在的后一个（也就是原来的前一个）接到下下个结点（如果没有则接到下一个）。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {  
        if(head == null) return null;
        ListNode helper = new ListNode(0);//制作头节点
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;//当前节点以及当前节点的后继节点
        
        while(cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            //头插逆置
            cur.next.next = cur;
            pre.next = cur.next;//cur和cur.next之间没断开
            
            //走下一步
            cur.next = next;
            pre = cur;
            cur = next;
        }
        
        return helper.next;//不是head，head已经变化了
    }  
} 

public class oj24_swap_nodes_in_pairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
