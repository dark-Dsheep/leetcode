package Competition.weekly.wr329;

import java.util.HashMap;

public class T3 {


    public boolean makeStringsEqual(String s, String target) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int xorCnt = 0, orCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (target.charAt(i) == '0' && s.charAt(i) == '1') {
                // 需要用一个1进行xor操作
                if (map.get('1') <= 0) return false;
                xorCnt++;
            }
            if (target.charAt(i) == '1' && s.charAt(i) == '0') {
                // 需要用一个1进行or 操作
                // 对应那个1 被xor成0
                if (map.get('1') <= 0) return false;
//                map.put('1', map.get('1') - 1);
                orCnt++;
            }
        }
        return orCnt == xorCnt;
    }

    public static void main(String[] args) {
        System.out.println(new T3().makeStringsEqual("101110100", "110011000"));
    }
}
