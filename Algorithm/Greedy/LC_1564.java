package Algorithm.Greedy;

import java.util.Arrays;

public class LC_1564 {

    /*
        1564. 把箱子放进仓库里 I
     */
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        // 将warehouse[i]变成前面的最低高度
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
        }
        Arrays.sort(boxes);
        int res = 0;
        // 贪心策略 -> 每次放高度最小的
        int j = 0;
        for (int i = warehouse.length - 1; i >= 0; i--) {
            if (warehouse[i] >= boxes[j]) {
                res += 1;
                j++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] boxes = {4,3,4,1};
        int[] warehouse = {5,3,3,4,1};
        System.out.println(new LC_1564().maxBoxesInWarehouse(boxes, warehouse));
    }

}
