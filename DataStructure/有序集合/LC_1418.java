package DataStructure.有序集合;

import java.util.*;

public class LC_1418 {

//    1418. 点菜展示表
    TreeSet<String> tset = new TreeSet<>();
    TreeMap<Integer, HashMap<String, Integer>> tmap = new TreeMap<>(((o1, o2) -> o1 - o2)); // 桌号 菜名 数量

    public List<List<String>> displayTable(List<List<String>> orders) {
        var ans = new ArrayList<List<String>>();
        for (var order : orders) {
            var tableNo = Integer.parseInt(order.get(1));
            var food = order.get(2);
            tset.add(food);
            tmap.computeIfAbsent(tableNo, v -> new HashMap<>());
            tmap.get(tableNo).put(food, tmap.get(tableNo).getOrDefault(food, 0) + 1);
        }
        var title = new ArrayList<String>();
        title.add("Table"); title.addAll(tset); ans.add(title);

        for (var entry : tmap.entrySet()) {
            var list = new ArrayList<String>();
            list.add(String.valueOf(entry.getKey()));
            var subEntry = entry.getValue();
            for (var food : tset) {
                list.add(String.valueOf(subEntry.getOrDefault(food, 0)));
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        var orders = new ArrayList<List<String>>();
        orders.add(List.of("Laura","2","Bean Burrito"));
        orders.add(List.of("Jhon","2","Beef Burrito"));
        orders.add(List.of("Melissa","2","Soda"));
        System.out.println(new LC_1418().displayTable(orders));
    }
}
