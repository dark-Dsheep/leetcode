package Competition.weekly.wr302;


import java.util.ArrayList;

public class T3 {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] q) {
        int n = q.length;
        var ans = new int[n];
        for (int i = 0; i < n; i++) {
            int k = q[i][0], t = q[i][1];
            var list = new ArrayList<String[]>();
            for (int j = 0; j < nums.length; j++) {
                var x = nums[j].substring(nums[j].length() - t);
                list.add(new String[]{x,j+""});
            }
            list.sort((o1, o2) -> {
                if (o1[0].equals(o2[0])) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            });
            ans[i] = Integer.parseInt(list.get(k-1)[1]);
        }
        return ans;
    }
}
