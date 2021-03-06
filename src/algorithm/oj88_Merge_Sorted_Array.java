/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author edward.guan
 *
题目： 
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note: 
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

翻译: 
给定2个排序好的整数数组nums1和nums2，把nums2合并到nums1中成为1个排序的数组。 
提示：你可以假定nums1有足够的空间（大小>=m+n）来容纳来自nums2的额外的元素。nums1和nums2的元素的个数各自被初始化为m和n。

分析： 
1. 如果nums1从前往后遍历的话，nums2中的元素需要插入nums1，这个时候每插入一次，就会需要将nums1的元素往后移动（或者需要申请额外的存储空间）。但是我们反过来想，由于合并后的数组长度是确定的，我们可以从最大的数开始写入，这个时候由于nums1的后面部分的空间是未使用的，刚好可以直接覆写。 
2. 需要考虑比较特殊的情况，就是数组可能为空。2个数组都为空自然进不去循环。但是其中一个为空，就要考虑数组可能发生越界的情况了。
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        for(int i = m+n-1;i >= 0;i--){
//        	p2 < 0
//          nums2中的元素已经全部插入到nums1中了
            if(p2 < 0 || (p1 >= 0 && nums1[p1] > nums2[p2])){
                nums1[i]=nums1[p1];
                p1--;
            }else{
                nums1[i]=nums2[p2];
                p2--;
            }
        }
    }
}

public class oj88_Merge_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = new int[] {1,2,3,0,0,0};
		int nums2[] = new int[] {2, 5, 6};
		int m = 3;
		int n = 3;
		new Solution().merge(nums1, m, nums2, n);
		System.out.println(nums1);
	}

}
