class Solution {
    int N, M;
    int[][] visited;
    Queue<int[]> q;
    private void bfs(int[][] heights, int val) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            for (var dir: dirs) {
                int i = x + dir[0];
                int j = y + dir[1];

                if (i < 0 || j < 0 || j > M - 1 || i > N - 1 || visited[i][j] >= val || heights[i][j] < heights[x][y])
                    continue;

                q.offer(new int[]{i, j});
                visited[i][j] += val;
            }
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        N = heights.length;
        M = heights[0].length;

        visited = new int[N][M];
        q = new LinkedList<>();

        // pacific 
        for (int j = 0; j < M; j++) {
            if (visited[0][j] < 1) { visited[0][j] += 1; q.offer(new int[]{0, j}); }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i][0] < 1) { visited[i][0] += 1; q.offer(new int[]{i, 0}); }
        }

        bfs(heights, 1);

        q.clear();

        // atlantic
        for (int j = 0; j < M; j++) {
            if (visited[N - 1][j] < 2 ) {
                q.offer(new int[]{N - 1, j});
                visited[N - 1][j] += 2;
            }
            
        }

        for (int i = 0; i < N; i++) {
            if (visited[i][M - 1] < 2) {
                q.offer(new int[]{i, M - 1});
                visited[i][M - 1] += 2;
            }
        }

        bfs(heights, 2);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 3) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }
}
