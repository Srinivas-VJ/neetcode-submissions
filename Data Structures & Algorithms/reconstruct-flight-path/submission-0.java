class Solution {
    Map<String, PriorityQueue<String>> adjList = new HashMap<>();

    private void dfs(String node, List<String> path) {
        var queue = adjList.getOrDefault(node, new PriorityQueue<>());
        while (!queue.isEmpty()) {
            var neigh = queue.poll();
            dfs(neigh, path);
        }

        path.add(node);

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (var ticket : tickets) {
            adjList.computeIfAbsent(ticket.get(0), a -> new PriorityQueue<String>()).offer(ticket.get(1));
        }
        List<String> path = new ArrayList<>();
        dfs("JFK", path);
        Collections.reverse(path);

        return path;
    }
}
