package DataStructure.HashMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class LC_1604 {


    public List<String> alertNames(String[] keyName, String[] keyTime) {
        var map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < keyName.length; i++) {
            var name = keyName[i];
            var time = convert(keyTime[i]);
            if (map.containsKey(name)) {
                List<Integer> list = map.get(name);
                list.add(time);
                map.put(name, list);
            } else {
                var list = new ArrayList<Integer>();
                list.add(time);
                map.put(name, list);
            }
        }
        var res = new ArrayList<String>();
        for (var entry : map.entrySet()) {
            if (check(entry.getValue())) {
                res.add(entry.getKey());
            }
        }
        res.sort(String::compareTo);
        return res;
    }

    private boolean check(List<Integer> list) {
        list.sort((Comparator.comparingInt(o -> o)));  // 将打卡时间从小到大排序
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 2) <= 60) { // 0 1 2 -> 连续三次
                return true;
            }
        }
        return false;
    }
    // 时间转换
    private int convert(String time) {
        int m = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int s = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return m * 60 + s;
    }

    public static void main(String[] args) {

    }
}
