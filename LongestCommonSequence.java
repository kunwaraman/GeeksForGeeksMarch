/*
time complexity: O(m*n)
space complexity: O(m*n)
 */
public class LongestCommonSequence {
    static int dp[][] = new int[1001][1001];
    static int lcs(String s1, String s2) {
        // code here
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }
        return recur(s1,s2,0,0,dp);

    }
    public static int recur(String s1,String s2,int i,int j,int dp[][]){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+recur(s1,s2,i+1,j+1,dp);
        }
        return dp[i][j]=Math.max(recur(s1,s2,i,j+1,dp),recur(s1,s2,i+1,j,dp));

    }
}
