class Solution {
    List<List<Integer>> adjList;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build the graph
        int[] indeg = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (var edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
            indeg[edge[0]]++;
        }

        // khan's algo
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int neigh : adjList.get(node)) {
                indeg[neigh]--;
                if (indeg[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        int[] res = order.stream().mapToInt(Integer::intValue).toArray();
        if (res.length != numCourses) 
            return new int[]{};
        return res;
        
    }
}
