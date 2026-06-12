class BinaryLifting{
    int[] parent;
    int[] depth;
    int[][] up;
    int LOG;

    public BinaryLifting(int n, ArrayList<Integer>[] adj){
        depth = new int[n+1];
        parent = new int[n+1];

        parent[1] = -1;
        depth[1] = 0;
        dfs(1, adj);

        LOG = 0;
        while((1<<LOG) < n) LOG++;
        up = new int[n+1][LOG+1];

        for(int u = 1; u <= n; u++){
            up[u][0] = parent[u];
        }
        for(int j = 1; j <= LOG; j++){
            for(int u = 1; u <= n; u++){
                if(up[u][j-1] != -1)
                    up[u][j] = up[up[u][j-1]][j-1];
                else
                    up[u][j] = -1;
            }
        }
    }

    void dfs(int node, ArrayList<Integer>[] adj){
        for(int v : adj[node]){
            if(v != parent[node]){
                parent[v] = node;
                depth[v] = depth[node] + 1;

                dfs(v, adj);
            }
        }
    }

    int jump(int node, int k){
        for(int i = LOG; i >= 0; i--){
            if((k & (1 << i)) != 0){
                if(node != - 1)
                    node = up[node][i];
                else 
                    break;
            }
        }
        return node;
    }

    int commonAncestor(int u, int v){
        if(u == v)
            return u;

        for(int i = LOG; i >= 0; i--){
            if(up[u][i] != up[v][i]){
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    int query(int u, int v){
        int dist = 0;
        if(depth[u] < depth[v]){
            u = u ^ v;
            v = u ^ v;
            u = u ^ v;
        }

        int k = depth[u] - depth[v];
        u = jump(u, k);
        dist += k;

        int lca = commonAncestor(u, v);

        dist += depth[u]+depth[v]-2*depth[lca];

        return dist-1 >= 0? exp(2, dist-1) : 0;
    }

    int exp(long x, int n){
        long MOD = (long)1e9+7;
        long res = 1;

        while(n > 0){
            if((n & 1) != 0){
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;

            n >>= 1;
        }
        return (int)res;
    }
}

class Solution {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int[] e : edges){
            int u = e[0], v = e[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        BinaryLifting obj = new BinaryLifting(n, adj);

        int q = queries.length;
        int[] ans = new int[q];

        for(int i = 0; i < q; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = obj.query(u, v);
        }
        return ans;
    }   
}