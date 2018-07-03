package algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目： 
全排列一个数组（元素有重复），结果集中不允许出现重复。

思路：
同47题
这个题跟Permutations非常类似，唯一的区别就是在这个题目中元素集合可以出现重复。
这给我们带来一个问题就是如果不对重复元素加以区别，那么类似于{1,1,2}这样的例子我们会有重复结果出现。
那么如何避免这种重复呢？方法就是对于重复的元素循环时跳过递归函数的调用，只对第一个未被使用的进行递归，
我们那么这一次结果会出现在第一个的递归函数结果中，而后面重复的会被略过。如果第一个重复元素前面的元素还没在当前结果中，
那么我们不需要进行递归。想明白了这一点，代码其实很好修改。首先我们要对元素集合排序，从而让重复元素相邻，
接下来就是一行代码对于重复元素和前面元素使用情况的判断即可。
 * @author edward.guan
 *
 */

class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0)
            return res;
        Arrays.sort(nums);//排序让重复元素排列在一起
        helper(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] num, boolean[] used, List<Integer> item, List<List<Integer>> res)
    {
        if(item.size() == num.length)
        {
            res.add(new ArrayList<>(item));
            return;
        }
        for(int i=0;i<num.length;i++)//循环递归处理子问题
        {   
            if(i > 0 && used[i - 1] && num[i - 1] == num[i]) continue;//如果第一个重复元素前面的元素还没在当前结果中，那么我们不需要进行递归
            if(!used[i])//这里并不是一直往后推进的，前面的数有可能放到后面，所以我们需要维护一个used数组来表示该元素是否已经在当前结果中，因为每次我们取一个元素放入结果，然后递归剩下的元素，所以不会出现重复
            {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
//                 在递归函数之后，我们把该元素从结果中移除，并把标记置为false，这个我们可以称为“保护现场”，递归函数必须保证在进入和离开函数的时候，变量的状态是一样的，这样才能保证正确性。
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
}

public class oj47_Permutations2 {
	public static void main(String[] args) throws IOException {
		int nums[] = new int[]{2,7,11,15,2};
        System.out.println(new Solution47().permuteUnique(nums));
    }
}
