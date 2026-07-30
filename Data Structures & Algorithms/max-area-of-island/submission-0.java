
class Solution {
    int N, M;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i == N || j == M || grid[i][j] == 0) 
            return 0;
        
        grid[i][j] = 0;
        int area = 1;

        for (var dir : dirs) {
            area += dfs(i + dir[0], j + dir[1], grid);
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        N = grid.length;
        M = grid[0].length; // assuming at least 1 row

        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }
}
