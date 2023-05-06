package 技巧.前缀和;

import java.util.Arrays;

public class LC_1352 {

    /*
        1352. 最后 K 个数的乘积
     */
    // TODO
    class ProductOfNumbers {

        int[] suffix;
        int index;

        public ProductOfNumbers() {
            this.suffix = new int[40010];
            Arrays.fill(suffix, 1);
            this.index = 0;
        }

        public void add(int num) {
            suffix[index] = suffix[index + 1] * num;
            index++;
        }
        public int getProduct(int k) {

            return -1;
        }
    }


    public static void main(String[] args) {
        ProductOfNumbers numbers = new LC_1352().new ProductOfNumbers();
        numbers.add(3);
        numbers.add(0);
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);

        System.out.println(numbers.getProduct(2));
        System.out.println(numbers.getProduct(3));
        System.out.println(numbers.getProduct(4));
    }
}
