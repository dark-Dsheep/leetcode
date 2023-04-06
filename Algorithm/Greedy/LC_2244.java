package Algorithm.Greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC_2244 {

    /*
        2244. 完成所有任务需要的最少轮数
     */
    public int minimumRounds(int[] tasks) {
        if (tasks.length < 2) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : tasks) map.put(x, map.getOrDefault(x, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                .collect(Collectors.toList());
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() >= 3) {
                res += Math.ceil(entry.getValue() / 3.0);
                continue;
            }
            if (entry.getValue() == 2) {
                res += Math.ceil(entry.getValue() / 2.0);
                continue;
            }
            return -1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(new LC_2244().minimumRounds(tasks));
    }
}
