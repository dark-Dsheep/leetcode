package Competition.weekly.wr335;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T3 {

    public int findValidSplit(int[] nums) {
        // 互质: 左半部分 和 右半部分 没有公共质因
        // 对于一个质数,将它的第一个出现的位置(left)和最后一次出现的位置(right)找出来
        // 答案不可能在中间 [left, right) => 答案可能是right
        // 答案是一个组区间的右端点的最大值
        // right[i] 记录 i 是左端点的情况右端点的最大值
        int n = nums.length;
        var left = new HashMap<Integer, Integer>(); // left[p] = p首次出现的下标
        var right = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int d = 2; d * d <= num; d++) {      // 质因数分解
                if (num % d == 0) {
                    left.putIfAbsent(d, i);         // 第一次遇到质数d
                    right[left.get(d)] = i;         // 记录左端点对应右端点的最大值
                    num /= d;
                    while (num % d == 0) num /= d;
                }
            }
            if (num > 1) {                            // x是一个大质数
                left.putIfAbsent(num, i);
                right[left.get(num)] = i;
            }
        }
        for (int l = 0, maxR = 0; l < n; l++) {
            if (l > maxR) { // 最远可以到达的maxR
                return maxR;
            }
            maxR = Math.max(maxR, right[l]);
        }
        return -1;
    }




    // 质因数分解
    List<Integer> divide(int x) {
        var list = new ArrayList<Integer>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                list.add(i);
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x > 1) list.add(x);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 8, 15, 3, 5};
        System.out.println(new T3().findValidSplit(nums));
    }
}
