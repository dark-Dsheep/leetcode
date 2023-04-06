package DataStructure.HashMap;

public class LC_1946 {


    /*
        1946. 子字符串突变后可能得到的最大整数
     */
    public String maximumNumber(String num, int[] change) {
        int[] map = new int[10];
        for (int i = 0; i < change.length; i++) {
            map[i] = change[i];
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        boolean flag = false; // 记录是否变化过
        for (char c : num.toCharArray()) {
            int v = c - '0';
            if (map[v] > v) { // 可替换
                sb.append(map[v]);
                flag = true;
                start++;
                continue;
            } else if (map[v] < v){
                if (flag) break;
            }
            sb.append(c);
            start++;
        }
        return sb.append(num.substring(start)).toString(); // 拼接剩下没变化的字串
    }

    // 方法二：贪心
    public String maximumNumber2(String num, int[] change) {
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int v = chars[i] - '0';
            if (change[v] > v) {
                // 贪心思路 -> 以第一个小于change[v]的下标为左边界 扩展右边界直到 change[v] < v
                while (i < chars.length && change[chars[i] - '0'] >= chars[i] - '0') {
                    chars[i] = (char) (change[chars[i] - '0'] + '0');
                    i++;
                }
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String num = "5";
        int[] change = {1, 4, 7, 5, 3, 2, 5, 6, 9, 4};
        System.out.println(new LC_1946().maximumNumber(num, change));
    }
}
