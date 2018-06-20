package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class simulation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Double> prices = new ArrayList<>();
        Map<Double, Integer> styles = new HashMap<>();
        
        for(int i = 0; i < m; i++){
        		List<Integer> style = new ArrayList<>();
            for(int j = 0; j < 2; j++){
                int x = sc.nextInt();
                style.add(x);
            }
            double price = (double)style.get(0) / style.get(1);
            prices.add(price);
            styles.put(price, style.get(0));
        }
        
        prices.add(1.0 * k);
        styles.put(1.0 * k, 1);
        
        Collections.sort(prices);//对单价进行排序
        
        double min  = 99999;
        int extra = n;
        for(int i = 0; i < prices.size(); i++) {
        		if(n <= styles.get(prices.get(i)) && prices.get(i) * styles.get(prices.get(i)) < min) {
        			min = prices.get(i) * styles.get(prices.get(i));
        		}else if(n > styles.get(prices.get(i))) {
        			//这种票卖完了
        			
        		}
        }
        
        System.out.println((int)min);
    }
    
}
