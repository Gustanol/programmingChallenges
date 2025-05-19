class Solution {
  public static int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE, profit = 0;
    
    for (int price : prices) {
      minPrice = Math.min(minPrice, price);
      profit = Math.max(profit, price - minPrice);
    }
    return profit;
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println(Solution.maxProfit(new int[]{1,3,4,5,7}));
  }
}