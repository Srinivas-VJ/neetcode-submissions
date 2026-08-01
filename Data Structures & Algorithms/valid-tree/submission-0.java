class DSU {
    
    int[] parent;

    private DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
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
        parent[p1] = p2;
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
