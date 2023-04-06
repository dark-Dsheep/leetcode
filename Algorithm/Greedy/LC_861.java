package Algorithm.Greedy;

public class LC_861 {


    /*
        861. 翻转矩阵后的得分
     */
    int m, n = 0;

    public int matrixScore(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) { // 反转每一行
                reverseRow(grid, i);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) { // 反转每一列
                reverseCol(grid, j);
            }
        }
        int res = 0;
        for (int[] g : grid) {
            StringBuilder sb = new StringBuilder();
            for (int x : g) {
                sb.append(x);
            }
            res += Integer.parseInt(sb.toString(), 2);
        }
        return res;
    }

    private void reverseCol(int[][] grid, int curCol) {
        for (int i = 0; i < m; i++) {
            if (grid[i][curCol] == 0) {
                grid[i][curCol] = 1;
            } else {
                grid[i][curCol] = 0;
            }
        }
    }

    private void reverseRow(int[][] grid, int curRow) {
        for (int j = 0; j < n; j++) {
            if (grid[curRow][j] == 0) {
                grid[curRow][j] = 1;
            } else {
                grid[curRow][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("111", 2));
        System.out.println(Integer.parseInt("100", 2));
        System.out.println(Integer.parseInt("110", 2));
    }
}
