package Competition.weekly.wr331;

import java.util.Arrays;
import java.util.HashSet;

public class T2 {
    private static final HashSet<Character> set = new HashSet<>() {
        {
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }
    };

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            String ss = words[i];
            char head = ss.charAt(0);
            char tail = ss.charAt(ss.length() - 1);
            if (set.contains(head) && set.contains(tail)) {
                nums[i] = 1;
            }
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
//        System.out.println(Arrays.toString(preSum));
        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            res[idx++] = preSum[r + 1] - preSum[l];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] q = {{0,2},{1,4},{1,1}};
        System.out.println(Arrays.toString(new T2().vowelStrings(words, q)));
    }
}
