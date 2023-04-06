package DataStructure.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_1711 {

    // 预处理小于2^20的二的幂 TODO
    static List<Integer> list = new ArrayList<>(){
        {
            for (int i = 0; i <= 21; i++) {
            add((int) Math.pow(2, i));
        }
    }

    };
    public int countPairs(int[] d) {
        int ans = 0;
        for (int x : list) {
            var map = new HashMap<Integer, Integer>();
            // 求两数之和 等于x的个数
            for (int i = 0; i < d.length; i++) {
                int key = x - d[i];
                if (map.containsKey(key)) { ans++; break; }
                map.put(key, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
