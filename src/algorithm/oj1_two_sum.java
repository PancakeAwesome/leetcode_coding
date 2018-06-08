package algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目： 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example: 
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9, 
return [0, 1].

翻译： 
给定一个整形数组和一个整数target，返回2个元素的下标，它们满足相加的和为target。 
你可以假定每个输入，都会恰好有一个满足条件的返回结果。

Java版代码1（时间复杂度O(n)）：
 * @author edward.guan
 *
 */

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer index=map.get(target-nums[i]);
            if(index==null){
                map.put(nums[i],i);
            }else{
                return new int[]{i,index};
            }
        }
        return new int[]{0,0};
    }
}

public class oj1_two_sum {
	public static void main(String[] args) throws IOException {
		int nums[] = new int[]{2,7,11,15};
		int target = 9;
        System.out.println(new Solution1().twoSum(nums, target));
    }
}
