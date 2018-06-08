package algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目： 
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: 
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) 
The solution set must not contain duplicate triplets. 
For example, given array S = {-1 0 1 2 -1 -4},

A solution set is:
(-1, 0, 1)
(-1, -1, 2)
1
2
3
4
翻译： 
给定一个数组S，它包含n个整数，它是否存在3个元素a，b，c，满足a+b+c=0?找出所有满足条件的元素数组。 
提示：a，b，c三个元素必须是升序排列（也就是满足a ≤ b ≤ c），最终的结果不能包含重复的元素数组。例如给定S为{-1 0 1 2 -1 -4}，返回结果是(-1, 0, 1)和(-1, -1, 2)。

分析： 
最容易想到的方法就是3重循环遍历所有可能的元素，进行判断是否等于0。下面的方案作了一些改进： 
1. 对数组进行排序，跳过肯定会大于0的结果 
2. 借助map避免第三层遍历 
3. 由于做了排序，所以可以较为容易的跳过重复的结果
 * @author edward.guan
 *
 */

class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
//         sort nums
        Arrays.sort(nums);
        
//         construct map
//         存放第三个数的map
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                List<Integer> subscripts = new ArrayList<>();
                subscripts.add(i);
                map.put(nums[i], subscripts);
            }else {
                map.get(nums[i]).add(i);
            }
        }
        
//         double loop to search
        for(int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            if(a > 0) {
//                 如果第一个数大于0说明第二第三的数不可能出现比他小的数
                break;
            }
            if(i - 1 >= 0 && nums[i - 1] == nums[i]) {
//                 remove overlap num
                continue;
            }
            for(int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                if(j >= i + 2 && nums[j - 1] == nums[j]) {
//                     remove overlap num
                    continue;
                }
                
                int finalNum = -a - b;
                
                if(finalNum < nums[j]) {
                    break;
                }
                
                if(map.get(finalNum) != null) {
                    List<Integer> subscripts = map.get(finalNum);
                    for(Integer subscript: subscripts) {
                        if(subscript != i && subscript != j) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(finalNum);
                            res.add(temp);
//                             第三个数只出现一次
                            break;
                        }
                    }
                }
            }
        }
        
        return res;
	}
}

public class oj15_3Sum {
	public static void main(String[] args) throws IOException {
		int nums[] = new int[]{0, 0, 0, 0};
//		int target = 9;
        System.out.println(new Solution15().threeSum(nums));
    }
}
