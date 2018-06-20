package algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目： 
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn’t matter what you leave beyond the new length.

翻译： 
给定一个数组和一个值，在原地移除所有的这个值的实例，并且返回新的数组长度。

元素的顺序可以被改变。而该数组在超过新长度的部分，可以不去管它。

分析： 
我的做法是把所有非给定值的元素，交换到数组的前面位置。
而这边做了一些优化，即只把非指定值替换到前面，而不需要把给定值替换到后面。
我创建了一个指针（数组下标），代表当前可作为写入新值的数组位置，同时循环结束后，它也是新数组的长度。
 * @author edward.guan
 *
 */

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int nextInsert = 0; //代表下次插入的位置
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[nextInsert++] = nums[i];
            }
        }
        
        return nextInsert;
    }
}

public class oj27_remove_element {
	public static void main(String[] args) throws IOException {
		int nums[] = new int[]{2,7,11,7,15,7};
		int target = 7;
        System.out.println(new Solution27().removeElement(nums, target));
    }
}
