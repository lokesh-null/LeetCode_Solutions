class Solution {
    public int dfs(int u,ArrayList<ArrayList<Integer>> adj,int[] vis){
        int max=0;
        vis[u]=1;
        for(int v:adj.get(u)){
            if(vis[v]==0){
                max=Math.max(dfs(v,adj,vis),max);
            }
        }
        return max+1;

    }
    public int assignEdgeWeights(int[][] edges) {
        //In tree number of vertex(n)==number of edges+1
        int n=edges.length+1;
        
        ArrayList<ArrayList<Integer>> adj_list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            //<= n because of 1 based indexing
            adj_list.add(new ArrayList<>());

        }
        int[] vis=new int[n+1];

        for(int[] edge:edges){
            // undirected so : u--v means u->v and v->u
            adj_list.get(edge[0]).add(edge[1]);
            adj_list.get(edge[1]).add(edge[0]);
        }
        // this will return max_depth possible starting from source=1
        int max_depth=dfs(1,adj_list,vis)-1;
        long ans = 1;
        long base = 2;
        long exp = max_depth - 1;
        long mod = 1000000007;

        while(exp > 0){
            if((exp & 1) == 1){
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return (int)ans;
        
    }
}