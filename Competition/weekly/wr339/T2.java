package Competition.weekly.wr339;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T2 {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
            max = Math.max(max, map.get(x));
        }
        for (int i = 0; i < max; i++) {
            List<Integer> ks = new ArrayList<>(map.keySet());
            List<Integer> list = new ArrayList<>();
            for (Integer k : ks) {
                if (map.get(k) == 0) {
                    map.remove(k);
                    continue;
                }
                list.add(k);
                map.put(k, map.get(k) - 1);
            }
            ans.add(list);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
