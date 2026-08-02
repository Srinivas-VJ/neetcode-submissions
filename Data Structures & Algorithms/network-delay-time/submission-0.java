class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = Integer.MAX_VALUE;
        // construct the graph
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (var edge : times) {
            adjList.get(edge[0] - 1).add(new int[]{edge[1] - 1, edge[2]});
        }

        // dijkstras
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != k - 1)
                dist[i] = inf;
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{k - 1, 0});

        while (!q.isEmpty()) {
            int[] nodePair = q.poll();
            int node = nodePair[0];
            int d = nodePair[1];

            for (int[] neighP : adjList.get(node)) {
                int neigh = neighP[0];
                int wt = neighP[1];
                if (dist[neigh] > d + wt) {
                    dist[neigh] = d + wt;
                    q.offer(new int[]{neigh, d + wt});
                }
            }
        }

        int time = Arrays.stream(dist)
                        .max()
                        .getAsInt();
        return time == inf ? -1 : time;
    }
}
