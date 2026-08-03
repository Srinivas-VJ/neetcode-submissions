class Solution {
    int N;
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDeg = new HashMap<>();
        Set<Character> nodes = new HashSet<>();
        int n = words.length;
        for (var word : words) {
            for (var ch : word.toCharArray()) {
                nodes.add(ch);
                inDeg.put(ch, 0);
            }
        }
        N = nodes.size();

        for (int i = 1; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < Math.min(words[i].length(), words[i - 1].length()); j++) {
                if (words[i].charAt(j) == words[i - 1].charAt(j))
                    continue;
                adjList.computeIfAbsent(words[i - 1].charAt(j), a -> new ArrayList<Character>()).add(words[i].charAt(j));
                inDeg.merge(words[i].charAt(j), 1, Integer::sum);
                found = true;
                break;
            }
            if (!found && words[i - 1].startsWith(words[i]) && !words[i].equals(words[i - 1]))
                return "";
        }

        return topoSort(adjList, inDeg);
    }

    private String topoSort(Map<Character, List<Character>> adjList, Map<Character, Integer> inDeg) {
        var res = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (var entry : inDeg.entrySet()) {
            if (entry.getValue() == 0) 
                q.offer(entry.getKey());
        }

        while (!q.isEmpty()) {
            var ch = q.poll();
            res.append(ch);

            for (var neigh : adjList.getOrDefault(ch, List.of())) {
                inDeg.put(neigh, inDeg.get(neigh) - 1);
                if (inDeg.get(neigh) == 0) {
                    inDeg.remove(neigh);
                    q.offer(neigh);
                }
            }
        }

        var result = res.toString();
        if (result.length() == N)
            return result;
        return "";

    }
}
