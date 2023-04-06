package Algorithm.Greedy;

public class LC_1899 {

//    1899. 合并若干三元组以形成目标三元组

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // 三个变量判断 triplets中是否存在 target的元素
        // 如果都存在则一定能合成 target
        boolean f1 = false, f2 = false, f3 = false;
        for (var t : triplets) {
            // 比target大的没必要判断
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            if (t[0] == target[0]) f1 = true;
            if (t[1] == target[1]) f2 = true;
            if (t[2] == target[2]) f3 = true;
        }
        return f1 && f2 && f3;
    }

    public static void main(String[] args) {

    }
}
