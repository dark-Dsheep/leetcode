package Competition.biweekly.bw102;

public class T1 {


    public int[] findColumnWidth(int[][] grid) {
        var m = grid[0].length;
        var n = grid.length;
        var ans = new int[m];
        for (int j = 0; j < m; j++) {
            int len = 0;
            for (int i = 0; i < n; i++) {
                len = Math.max(len, String.valueOf(grid[i][j]).length());
            }
            ans[j] = len;
        }
        return ans;
    }




    public static void main(String[] args) {

    }
}
