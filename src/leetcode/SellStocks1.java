package leetcode;

/**
 * 买卖股票的最佳时机
 * @Author: Zyl
 * @Date: 2020/2/19 10:57
 */
public class SellStocks1 {

    public static void main(String[] args) {
        SellStocks1 ss = new SellStocks1();
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{};
        System.out.println(ss.maxProfit(prices));
        System.out.println(ss.maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int between = 0;
        for(int num : prices){
            if(num < min){
                min = num;
            }
            if((num - min) > between){
                between = (num - min);
            }
        }
        return between;
    }
}
