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
题目： 
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

For example: 
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
1
2
3
4
5
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
1
2
3
4
5
分析： 
层次遍历二叉树，就是首先访问二叉树的第一层元素，再访问第二层，接着访问第三层，以此类推。实现的方式是，用一个先进先出的队列作为辅助数据结构，
用levelList保存每一层的元素，用resultList保存所有的levelList，然后 
（1）把根节点入队列，并把一个哨兵节点入队列，哨兵节点用于标识某一层已经结束 
（2）当队列中元素个数大于1时（除哨兵节点外还有其它元素），进入循环。访问该元素，如果该元素为哨兵节点，则说明这一层已经结束了，
并将一个哨兵节点入队，用于标识下一层结束的地方，把levelList存入resultList，并建一个新的levelList保存下一层的元素；
否则，把该节点的值放进levelList，并把它不为null的孩子节点入队。 
（3）把levelList加入resultList。因为最后一个哨兵节点没有办法被访问到，导致保存最后一层元素的levelList没办法在循环中被添加进resultList。
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
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        queue.offer(root);
        queue.offer(null);//null节点作为哨兵节点入队
        
        while(queue.size() > 1) {//保证队内除了null节点还有元素节点
            TreeNode p = queue.poll();
            
            if(p == null) {
                //这层节点遍历完毕
                res.add(list);
                queue.offer(null);//新的哨兵节点入队
                list = new ArrayList<>();//清空层列表
            }else {
                list.add(p.val);
                if(p.left != null) {
                    queue.offer(p.left);
                }

                if(p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        
        res.add(list);//最后一个null节点无法在循环内添加列表
        
        return res;
    }
}

public class oj13_roman_to_integer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
