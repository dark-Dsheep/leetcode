package Competition.biweekly.bw97;

public class T4 {


    public boolean isPossibleToCutPath(int[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        if (m == 1) {
            if (n == 2) return false;
            else return true;
        }
        if (m > 1 && n > 2) {
            var a = grid[m - 2][n - 1]; // 最后一个的上面
            var b = grid[m - 1][n - 2]; // 最后一个的左边
            // case1
            if (a == 0 || b == 0) return true;
        }
        // 水平方向算
        for (var i = 0; i < m; i++) {
            var oneCnt = 0;
            for (var j = 0; j < n; j++) {
                if (grid[i][j] == 1) oneCnt++;
            }
            if (oneCnt == 1) return true;
        }
        // 对角线算
//        if (check(grid)) return true;
        check(grid);
        return false;
    }

    public boolean check(int[][] matrix) {
        int length = matrix.length;
        int diagonalLines = (length + length) - 1;
        int itemsInDiagonal = 0;
        int midPoint = (diagonalLines / 2) + 1;
        for (int i = 1; i <= diagonalLines; i++) {
            int rowIndex = 0;
            int columnIndex = 0;
            int ontCnt = 0;
            if (i <= midPoint) {
                itemsInDiagonal++;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = (i - j) - 1;
                    columnIndex = j;
                    if (matrix[rowIndex][columnIndex] == 1) ontCnt++;
                    System.out.print(matrix[rowIndex][columnIndex] + " ");
                }
            } else {
                itemsInDiagonal--;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = (length - 1) - j;
                    columnIndex = (i - length) + j;
                    if (matrix[rowIndex][columnIndex] == 1) ontCnt++;
                    System.out.print(matrix[rowIndex][columnIndex] + " ");
                }
            }
//            if (rowIndex == 0 && columnIndex == 0) continue;
//            if (rowIndex == length - 1 && columnIndex == matrix[0].length - 1) continue;
//            if (ontCnt == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0,0},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,0,1},{0,0,0,1,1,1},{0,0,0,1,0,1},{0,0,0,1,0,1},{0,0,0,1,0,1},{0,0,0,1,0,1},{0,0,0,1,1,1}};
        System.out.println(new T4().isPossibleToCutPath(grid));
    }
}
