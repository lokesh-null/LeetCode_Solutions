class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        if(restrictions.length==0)return n-1;
        int m=restrictions.length;
        Arrays.sort(restrictions,(a,b)->a[0]-b[0]);
        int l=restrictions[0][0];
        int r=restrictions[0][1];
        if(r>l-1){
            restrictions[0][1]=l-1;
        }
        for(int i=1;i<restrictions.length;i++){
            restrictions[i][1]=Math.min(restrictions[i][1],restrictions[i-1][1]+(restrictions[i][0]-restrictions[i-1][0]));
        }
        for(int i=restrictions.length-2;i>=0;i--){
             restrictions[i][1]=Math.min(restrictions[i][1],restrictions[i+1][1]+(restrictions[i+1][0]-restrictions[i][0]));
        }
        int max=restrictions[m-1][1]+(n-restrictions[m-1][0]);
        for(int i=m-1;i>0;i--){
            int h1=restrictions[i-1][1];
            int hi=restrictions[i-1][0];
            int h2=restrictions[i][1];
            int hj=restrictions[i][0];
            if(hj-hi==Math.abs(h1-h2)){
                max=Math.max(max,Math.max(h1,h2));
            }
            else if(hj-hi>Math.abs(h1-h2)){
                int nh=(hj-hi-Math.abs(h1-h2))/2;
                max=Math.max(max,Math.max(h1,h2)+nh);
            }
        }
         int h1=0;
            int hi=1;
            int h2=restrictions[0][1];
            int hj=restrictions[0][0];
            if(hj-hi==Math.abs(h1-h2)){
                max=Math.max(max,Math.max(h1,h2));
            }
            else if(hj-hi>Math.abs(h1-h2)){
                int nh=(hj-hi-Math.abs(h1-h2))/2;
                max=Math.max(max,Math.max(h1,h2)+nh);
            }
        return max;
    }
}