package Skill.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_2363 {

//    2363. 合并相似的物品

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(items2, (o1, o2) -> o1[0] - o2[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < items1.length && j < items2.length) {
            int v1 = items1[i][0];
            int v2 = items2[j][0];
            if (v1 < v2) {
                ans.add(List.of(v1, items1[i][1]));
                i++;
            } else if (v1 > v2) {
                ans.add(List.of(v2, items2[j][1]));
                j++;
            } else {
                ans.add(List.of(v1, items1[i][1] + items2[j][1]));
                i++; j++;
            }
        }
        while (i < items1.length) {
            ans.add(List.of(items1[i][0], items1[i][1]));
            i++;
        }
        while (j < items2.length) {
            ans.add(List.of(items2[j][0], items2[j][1]));
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
