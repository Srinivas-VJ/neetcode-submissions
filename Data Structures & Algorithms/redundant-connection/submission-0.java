class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int a) {
        while (parent[a] != a) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }

    public boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > rank[p2]) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        parent[p1] = parent[p2];
        rank[p2] += rank[p1];
        return true; 
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        var dsu = new DSU(edges.length + 1);
        for (var edge : edges) {
            if (!dsu.union(edge[0], edge[1]))
                return edge;
        }
        return new int[]{};
    }
}
