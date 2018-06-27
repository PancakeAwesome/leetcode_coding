package algorithm;

import java.util.Scanner;

/**
 * 问题：
 * 今年的世界杯要开始啦，牛牛作为一个球迷，当然不会放过去开幕式现场的机会。但是牛牛一个人去又觉得太过寂寞，便想叫上了他的n个小伙伴陪他一起去莫斯科(一共n+1人)。当牛牛开始订开幕式的门票时，发现门票有m种套餐，每种套餐需要花费x元，包含y张门票，每张门票也可以单独购买，此时这张门票的价格为k元。请问牛牛要怎样选择购买门票，使得他花费的钱最少。(每种套餐可以购买次数没有限制)。

输入描述:
第一行输入三个数字n(0≤n≤999)、m(1≤m≤1000)和k(1≤k≤100000)
接下来m行，每行输入两个数字xi(1≤xi≤100000)和yi(2≤yi≤1000), 表示套餐的价格和套餐内包含的门票数量。


输出描述:
输出牛牛至少要花费的钱的数量。

分析
这个题可以看做是一个完全背包，人的个数相当于背包的容量，票的价格相当于价值，
dp[i]表示买到i张票时的最小花费为dp[i]，
最后dp[n]即为买到n张票时的最小花费（程序中的n是加上牛牛自己时的数量）。
 * @author edward.guan
 *
 */

public class simulation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1;//i个人
        int m = sc.nextInt();//m种套餐
        int k = sc.nextInt();//门票单价
        int[] dp = new int[1000];//门票最优价格数组

        for(int i = 1; i <= n; i++) {
            dp[i] = i*k;
        }

        while(m >= 1) {
            //找最优方案
            int x = sc.nextInt();//套餐价格
            int y = sc.nextInt();//套餐内的人数
            for(int i = 1; i <= n; i++) {
                if(i >= y) {
                    dp[i] = Math.min(dp[i], dp[i - y] + x);
                }else {
                    dp[i] = Math.min(dp[i], x);
                }
            }
            m--;
        }
        
        System.out.println(dp[n]);
    }
}

