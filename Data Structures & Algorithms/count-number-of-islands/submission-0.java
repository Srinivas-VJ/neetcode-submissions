class Solution {
    int[][] diffs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void dfs(int i, int j, boolean[][] visited,char[][] grid) {
        int n = grid.length;
        int m = grid[0].length; // assuming at least 1 size

        if (i < 0 || j < 0 || i == n || j == m || visited[i][j] || grid[i][j] != '1')
            return;
        
        visited[i][j] = true;

        for (var delta : diffs) {
            var x = i + delta[0];
            var y = j + delta[1];
            dfs(x, y, visited, grid);
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        int n = grid.length;
        int m = grid[0].length; // assuming at least 1 size

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    islands++;
                }
            }
        }

        return islands;
    }
}
