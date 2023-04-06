package Competition.biweekly.bw84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1 {

    public List<List<Integer>> mergeSimilarItems(int[][] A, int[][] B) {
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        Arrays.sort(B, (a, b) -> a[0] - b[0]);
        var ans = new ArrayList<List<Integer>>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            var a = A[i];
            var b = B[j];
            if (a[0] == b[0]) {
                a[1] += b[1];
                i++;
                j++;
                ans.add(List.of(a[0], a[1]));
            } else if (a[0] < b[0]) {
                i++;
            } else {
                j++;
            }
        }
        while (i < A.length) ans.add(List.of(A[i][0], A[i++][1]));
        while (j < B.length) ans.add(List.of(B[i][0], B[j++][1]));
        return ans;
    }
}
