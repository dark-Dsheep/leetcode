package Algorithm.TopoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LC_207 {

//    207. 课程表 TOP序

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] rd = new int[numCourses];
        ArrayList<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var p : prerequisites) {
            g[p[0]].add(p[1]);
            rd[p[1]]++;
        }
        var q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (rd[i] == 0) q.offer(i);
        }
        while (q.size() > 0) {
            int u = q.poll();
            numCourses--;
            for (int v : g[u]) {
                if (--rd[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {

    }
}
