package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_1985 {

    /*
        1985. 找出数组中的第 K 大整数
     */

    public String kthLargestNumber(String[] nums, int k) {
        // n个数字
        // 第k大整数 -> n-k+1小整数
        PriorityQueue<String> queue = new PriorityQueue<>(((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length()));
//        PriorityQueue<BigInteger> queue = new PriorityQueue<>((BigInteger::compareTo));
//        for (String s : nums) queue.offer(new BigInteger(s));
        for (String s : nums) queue.offer(s);
        int l = nums.length - k + 1;
//        System.out.println(l);
//        BigInteger res = BigInteger.ZERO;
        String res = "";
        while (l-- > 0) {
            res = queue.poll();
        }
        return res;

        /*
         解法二：自定义排序
        Arrays.sort(nums, ((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length()));
        return nums[nums.length - k];
         */
    }

    public static void main(String[] args) {

        String[] nums = {"3", "6", "7", "10"};
        int k = 4;
        System.out.println(new LC_1985().kthLargestNumber(nums, k));
    }
}
