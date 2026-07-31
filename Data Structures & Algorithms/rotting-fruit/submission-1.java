class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                visited[x][y] = true;
                if (grid[x][y] == 1) {
                    grid[x][y] = 2;
                    fresh--;
                }
                

                for (var dir: dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i < 0 || j < 0 || i == n || j == m || grid[i][j] != 1 || visited[i][j])
                        continue;
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
            if (fresh == 0)
                break;
            minutes++;
        }

        return fresh == 0 ? minutes : -1;

        
    }
}
