package arrays;

public class BuySellStocks {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            } else if((prices[i] - min) > max){
                max = prices[i] - min;
            }
        }
            return max;
    }
}

class Main {
    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        BuySellStocks obj = new BuySellStocks();
        int result = obj.maxProfit(prices);
        System.out.println(result);

        int[] p = {7,6,4,3,1};
        BuySellStocks obj2 = new BuySellStocks();
        int result2 = obj.maxProfit(p);
        System.out.println(result2);
    }
}

