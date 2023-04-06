package DataStructure.HashMap;

import java.util.HashMap;

public class LC_1357 {

    /*
        1357. 每隔 n 个顾客打折
     */
    class Cashier {
        int cnt, n, discount;
        HashMap<Integer, Double> map = new HashMap<>();

        public Cashier(int n, int discount, int[] products, int[] prices) {
            for (int i = 0; i < prices.length; i++) {
                map.put(products[i], (double) prices[i]);
            }
            this.n = n;
            this.discount = discount;
            this.cnt = 1;
        }

        public double getBill(int[] product, int[] count) {
            double res = 0.000;
            if (cnt == n) {
                for (int i = 0; i < product.length; i++) {
                    double curAmount = map.get(product[i]) * count[i];
                    res += (curAmount - (discount * curAmount) / 100);
                }
                cnt = 1;
            } else {
                for (int i = 0; i < product.length; i++) {
                    double curAmount = map.get(product[i]) * count[i];
                    res += curAmount;
                }
                cnt++;
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
