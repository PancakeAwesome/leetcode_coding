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
 *【题目】

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

【解析】
题意：有很多个区间，把有重叠的区间合并。

思路：分情况讨论将区间插入到结果集中。

用Java自带的sort()方法，只要自己重写compare()方法即可。
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//         插入用链表比较快
        List<Interval> res = new ArrayList<>();
        
        if(intervals != null) {
            for(Interval interval: intervals) {
//                 newInterval == null 代表插入区间已经插入到列表中了
//                 将比插入区间小的区间插入到结果集中
                if(newInterval == null || newInterval.start > interval.end) {
                    res.add(interval);
                }
//                 将插入区间加入到结果集中
                else if(newInterval.end < interval.start) {
//                     链表插入操作
                    res.add(newInterval);
                    res.add(interval);
                    newInterval = null;
                }
//                 插入区间和当前区间有重合
                else {
                    newInterval.start = Math.min(interval.start, newInterval.start);
                    newInterval.end = Math.max(interval.end, newInterval.end);
                }
            }
        }
        
//         插入区间没有插入到结果集中
        if(newInterval != null) {
            res.add(newInterval);
        }
        
        return res;
    }
}

public class oj57_Insert_Interval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
