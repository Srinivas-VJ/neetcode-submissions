class Solution {
    List<List<Integer>> adjList;
    boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[numCourses];
        for (var edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
        }

        return !hasCycle();
    }

    private boolean hasCycle() {
        int n = adjList.size();

        for (int i = 0; i < n; i++) {
            if (dfs(i, new HashSet<Integer>()))
                return true;
        }
        return false;
    }

    private boolean dfs(int i, Set<Integer> path) {
        if (path.contains(i))
            return true;

        if (visited[i])
            return false;
        
        boolean res = false;

        Set<Integer> temp = new HashSet<>(path);
        temp.add(i);

        for (int neigh : adjList.get(i)) {
            if (!visited[neigh]) {
                res |= dfs(neigh, temp);
            }
        }
        visited[i] = true;
        return res;
    }
}
