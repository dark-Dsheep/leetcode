package Competition.weekly.wr303;

public class T2 {

    public int equalPairs(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                cnt += cal(i, j, grid);
            }
        }
        return cnt;
    }

    int cal(int i, int j, int[][] grid) {
        for (int k = 0; k < grid.length; k++) {
            if (grid[i][k] != grid[k][j]) {
                return 0;
            }
        }
        return 1;
    }
}
