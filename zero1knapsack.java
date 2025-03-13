
public class zero1knapsack {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            }
        }
        return knap(W,wt,val,n,dp);

    }
    static int knap(int W,int wt[],int val[],int n,int dp[][]){
        if(n==0||W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            dp[n][W]=Math.max(val[n-1]+knap(W-wt[n-1],wt,val,n-1,dp),knap(W,wt,val,n-1,dp));
        }else if(wt[n-1]>W){
            return dp[n][W]= knap(W,wt,val,n-1,dp);
        }
        return dp[n][W];


    }
}
