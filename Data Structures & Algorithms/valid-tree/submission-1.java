class DSU {
    
    int[] parent;
    int[] rank;

    private DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int a) {
        while (parent[a] != a) {
            a = find(parent[a]);
        }
        return parent[a];
    }

    public boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (rank[p1] > rank[p2]) {
            parent[p1] = p2;
            rank[p1] += rank[p2];
        } else {
            parent[p2] = p1;
            rank[p2] += rank[p1];
        }
        
        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        
        var dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        int parent = dsu.find(0);

        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != parent)
                return false;
        }
        return true;
    }
}
