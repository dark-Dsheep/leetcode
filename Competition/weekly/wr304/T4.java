package Competition.weekly.wr304;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T4 {

    public int longestCycle(int[] edges) {
        Tarjan tarjan = new Tarjan(edges);
        int ans = -1;
        for (var l : tarjan.list) {
            ans = Math.max(ans, l.size());
        }
        return ans == 1 ? -1 : ans;
    }

    // Tarjan板子
    class Tarjan {
        private int V;      // 顶点个数
        private int time;   // 时间戳
        private int[] dfn;  // 每个点的访问时间戳
        private int[] low;
        private int[] edges;
        private boolean[] inStack;
        private LinkedList<Integer> stack;
        List<List<Integer>> list;

        public Tarjan(int[] edges) {
            this.edges = edges;
            this.V = edges.length;
            this.dfn = new int[V];
            this.low = new int[V];
            this.inStack = new boolean[V];
            this.stack = new LinkedList<>();
            this.list = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if (dfn[i] == 0) {
                    dfs(i);
                }
            }
        }

        private void dfs(int u) {
            stack.push(u);
            inStack[u] = true;
            dfn[u] = low[u] = ++time;
            int v = edges[u];
            if (v != -1) {
                if (dfn[v] == 0) {
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);  //
                } else if (inStack[v]) { // y在栈中 x->y是后向边
                    low[u] = Math.min(low[u], dfn[v]);
                }
            }
            if (dfn[u] == low[u]) {
                List<Integer> l = new ArrayList<>();
                while (stack.size() > 0 && stack.peek() != u) {
                    Integer p = stack.pop();
                    l.add(p);
                    inStack[p] = false;
                }
                l.add(stack.pop());
                list.add(l);
            }
        }
    }


    public static void main(String[] args) {
        int[] e = {3, 3, 4, 2, 3};
        System.out.println(new T4().longestCycle(e));
    }
}
