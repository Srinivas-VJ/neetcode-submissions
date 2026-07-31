class Cell {
    public Cell(int i, int j) {
        x = i;
        y = j;
    }
    int x;
    int y;
}

class Solution {
    int N, M;
    
    private boolean isValidCell(Cell cell, int[][] grid) {
        int x = cell.x;
        int y = cell.y;
        int inf = 2147483647;

        if (x < 0 || y < 0 || x == N || y == M || grid[x][y] != inf) {
            return false;
        }
        return true;
    }

    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int n = grid.length;
        int m = grid[0].length;
        N = n;
        M = m;

        Queue<Cell> q = new LinkedList<>();

        // init the q
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Cell(i, j));
                }
            }
        }

        // bfs
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                var cell = q.poll();
                if (isValidCell(cell, grid) || distance == 0) {
                    for (var dir: dirs)
                        q.offer(new Cell(cell.x + dir[0], cell.y + dir[1]));
                    grid[cell.x][cell.y] = distance;
                }
            }
            distance++;
        }
    }
}
