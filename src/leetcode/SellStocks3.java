package leetcode;

/**
 * 买卖股票的最佳时机2
 * @Author: Zyl
 * @Date: 2020/2/19 10:57
 */
public class SellStocks3 {

    public static void main(String[] args) {
        SellStocks3 ss = new SellStocks3();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int[] prices2 = new int[]{};
        System.out.println(ss.maxProfit(prices));
        System.out.println(ss.maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0){
            return 0;
        }

        int[] betweenList = new int[2];
        System.out.println(betweenList.length);
        int min = prices[0];

//        for(int i = 1; i < prices.length; i++){
//            if(prices[i] > min){
//                sum += prices[i] - prices[i - 1];
//                min = prices[i];
//            }
//            if(prices[i] < min){
//                min = prices[i];
//            }
//
//        }

        int sum = 0;
        for (int between : betweenList){
            sum += between;
        }
        return sum;
    }
}
