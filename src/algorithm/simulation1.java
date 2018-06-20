package algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class simulation1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> stars = new ArrayList<>();//用来记录星星的位置
        int n = sc.nextInt();
        int x, a = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
        		List<Integer> starList = new ArrayList<>();
            for(int j = 0; j < 2; j++){
                x = sc.nextInt();
                starList.add(x);
            }
            stars.add(starList);
        }
        
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
        		List<Integer> rect = new ArrayList<>();
            for(int j = 0; j < 4; j++){
                a = sc.nextInt();
                rect.add(a);
            }
            res.add(count(rect, stars));
        }
        
        for(int j = 0; j < res.size(); j++) {
            System.out.println(res.get(j));
        }
    }
    
    public static int count(List<Integer> rect, List<List<Integer>> l) {
        //记录矩形框内星星的个数
        int count = 0;
        for(int i = 0; i < l.size(); i++) {
            List<Integer> star = l.get(i);
//            System.out.println(star.get(0) + "" + star.get(1));
//            System.out.println(rect.get(0) + "" + rect.get(1)+rect.get(2)+rect.get(3));
            if((star.get(0) >= rect.get(0) && star.get(0) <= rect.get(2)) && (star.get(1) >= rect.get(1) && star.get(1) <= rect.get(3))) {
                count++;
            }
        }
        
        return count;
    }
}
