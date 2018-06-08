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

思路：先排序，然后检查相邻两个区间，看前一个区间的结尾是否大于后一个区间的开始，注意前一个区间包含后一个区间的情况。

用Java自带的sort()方法，只要自己重写compare()方法即可。
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return new ArrayList<Interval>();
//         1. sort Intervals
        Collections.sort(intervals, new Comparator<Interval> () {
            
            @Override
            public int compare(Interval a, Interval b) {
                
                return a.start - b.start;
            }
        });
        
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        
//         2.loop Intervals
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= res.get(res.size() - 1).end && intervals.get(i).start >= res.get(res.size() - 1).start) {
                if(intervals.get(i).end > res.get(res.size() - 1).end) {
                    //                 merge two intervals
                    res.get(res.size() - 1).end = intervals.get(i).end;
                }
            }else {
//                 create a new interval
                Interval temp = new Interval(intervals.get(i).start, intervals.get(i).end);
                res.add(temp);
            }
        }
        
        return res;
    }
}

public class oj56_Merge_Intervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
