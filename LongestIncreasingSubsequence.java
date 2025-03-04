public class LongestIncreasingSubsequence {
    static int dp[][] = new int[1001][1001];
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }
        return recur(arr,0,-1,dp);


    }
    public static int recur(int nums[],int i,int p,int dp[][]){
        int n = nums.length;
        if(i>=n){
            return 0;
        }
        if(p!=-1 && dp[i][p]!=-1){
            return dp[i][p];
        }
        int take=0;
        if(p==-1 || nums[i]>nums[p]){
            take=1+recur(nums,i+1,i,dp);
        }
        int skip = recur(nums,i+1,p,dp);
        if(p!=-1){
            dp[i][p]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}
