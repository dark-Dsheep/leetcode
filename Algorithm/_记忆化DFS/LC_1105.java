package Algorithm._记忆化DFS;


import java.util.Arrays;

public class LC_1105 {

//    1105. 填充书架

    int[] f = new int[1010];
    int[][] a;
    int sw;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // =====================递推===========================
        // int n = books.length;
        // for (int i = 0; i < n; i++) {
        //     f[i+1] = Integer.MAX_VALUE;
        //     int sum = 0;
        //     int maxH = 0; // 这一层最大高度
        //     for (int j = i; j >= 0; j--) {
        //         sum += books[j][0];
        //         if (sum > shelfWidth) break;
        //         maxH = Math.max(maxH, books[j][1]);
        //         f[i+1] = Math.min(f[i+1], f[j] + maxH);
        //     }
        // }
        // return f[n];
        // =====================================================
        a = books;
        sw = shelfWidth;
        Arrays.fill(f, -1);
        return dfs(a.length - 1);
    }

    int dfs(int i) {
        if (i < 0) return 0;
        if (f[i] != -1) return f[i];
        int ans = Integer.MAX_VALUE;
        int maxH = 0; // 这一层最大高度
        for (int j = i, sum = 0; j >= 0; j--) {
            sum += a[j][0];
            if (sum > sw) break;
            maxH = Math.max(maxH, a[j][1]);
            ans = Math.min(ans, dfs(j - 1) + maxH);
        }
        return f[i] = ans;
    }


    public static void main(String[] args) {
        int[][] books = {{1, 3}, {2, 4}, {3, 2}};
        int sw = 6;
        System.out.println(new LC_1105().minHeightShelves(books, sw));
    }
}
