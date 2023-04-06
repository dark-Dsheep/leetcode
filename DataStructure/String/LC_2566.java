package DataStructure.String;

public class LC_2566 {

    public int minMaxDifference(int num) {
        // 枚举将0-9替换得到的最大最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        var s = String.valueOf(num);
        for (int i = 0; i <= 9; i++) {
            String x = s.replaceAll(i + "", "0");
            min = Math.min(min, Integer.parseInt(x));
        }
        for (int i = 0; i <= 9; i++) {
            String x = s.replaceAll(i + "", "9");
            max = Math.max(max, Integer.parseInt(x));
        }
        return max - min;
    }

    public static void main(String[] args) {

    }
}
