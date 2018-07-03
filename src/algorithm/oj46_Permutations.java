package algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目： 
全排列一个数组（元素无重复），结果集中不允许出现重复。

思路：
这是一个np难问题，可以用套路：循环递归子问题来解决。
 * @author edward.guan
 *
 */

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0)
            return res;
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
            if(!used[i])//这里并不是一直往后推进的，前面的数有可能放到后面，所以我们需要维护一个used数组来表示该元素是否已经在当前结果中，因为每次我们取一个元素放入结果，然后递归剩下的元素，所以不会出现重复
            {
                used[i] = true;//代表该元素已经在结果集中
                item.add(num[i]);
                helper(num, used, item, res);
//                 在递归函数之后，我们把该元素从结果中移除，并把标记置为false，这个我们可以称为“保护现场”，递归函数必须保证在进入和离开函数的时候，变量的状态是一样的，这样才能保证正确性。
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
}

public class oj46_Permutations {
	public static void main(String[] args) throws IOException {
		int nums[] = new int[]{2,7,11,15};
        System.out.println(new Solution46().permute(nums));
    }
}
