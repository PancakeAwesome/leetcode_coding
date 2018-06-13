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
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
             
思路：
因为二叉排序树的中序遍历会是一个递增序列，由此特性可以判断一个BST的合法性。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution98 {
    public boolean isValidBST(TreeNode root) {
//         遍历bst应该是递增序列
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return true;
        TreeNode p = root;
        
        while(p != null || !stack.isEmpty()) {
            if(p != null) {

                stack.push(p);
                p = p.left;
            }else {
//                 遍历找到最左下角的节点
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        
        if(list.size() == 1) return true;
//         judge list whether in order
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        
        return true;
    }
}

public class oj98_validate_BST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int nums1[] = new int[] {1,2,3,0,0,0};
//		int nums2[] = new int[] {2, 5, 6};
//		int m = 3;
//		int n = 3;
//		new Solution().merge(nums1, m, nums2, n);
//		System.out.println(nums1);
	}

}
