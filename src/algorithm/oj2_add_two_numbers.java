package algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *题目： 
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
Output: 7 -> 0 -> 8

翻译： 
给你2个链表，代表2个非负整数。链表中整数的每一位数字的存储是反序的，数组的每个节点都包含一个数字。把2个非负整数相加，并且用一个链表返回。 
输入: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
输出: 7 -> 0 -> 8

分析： 
由于刚好链表中数的存储是反序，也就是个位在最前面，正好方便我们从低位开始加。需要注意的几个点： 
1. 传入[][],也就是2个空链表，要返回null 
2. 传入[0][0]，也就是2个整数是0的处理，要返回[0] 
3. 传入[5][5],要新增一个节点，存储进位。也就是判断是否结束，要根据2个链表是否为空和是否有进位来判断。
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
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        ListNode head=new ListNode(0);
        ListNode currentNode=head;
        int fix=0;//进位标志
        while(l1!=null||l2!=null||fix!=0){
            int val1=0;
            int val2=0;
            if(l1!=null){
                val1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val2=l2.val;
                l2=l2.next;
            }
            int sum=val1+val2+fix;
            fix=0;
            if(sum>9){
                fix=1;//进位
                sum-=10;
            }
//             尾插构建链表
            ListNode p = new ListNode(0);
            currentNode.next= p;
            p.val=sum;
            currentNode=p;
        }
    
        return head.next;
    }

}

public class oj2_add_two_numbers {
	public static void main(String[] args) throws IOException {
//		int nums[] = new int[]{2,7,11,15};
//		int target = 9;
//        System.out.println(new Solution1().twoSum(nums, target));
    }
}
