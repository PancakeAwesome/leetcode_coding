/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;

/**题目: 
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

翻译: 
合并2个已经排序的链表，并且返回一个新的链表。这个新的链表应该由前面提到的2个链表的节点所组成。

分析： 
注意头节点的处理，和链表结束（next为null）的处理。以下代码新增了一个头指针，来把头节点的处理和普通节点的处理统一了。
 * @author edward.guan
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         create new List
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        
//         loop l1 & l2
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
//                 insert node to rear
                currentNode.next = l1;
                l1 = l1.next;
            }else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        
        if(l1 != null) {
            currentNode.next = l1;
        }
        if(l2 != null) {
            currentNode.next = l2;
        }
        return head.next;
    }
}

public class oj21_Merge_Two_Sorted_Lists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
