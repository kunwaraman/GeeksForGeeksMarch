
public class LongestPalindromicSubsequence {
    int dp[][];
    public int longestPalinSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return recur(s,0,n-1);
    }
    public int recur(String s ,int i,int j){
        int n = s.length();
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==j){
            return 1;
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= 2+recur(s,i+1,j-1);
        }else{
            return dp[i][j]=Math.max(recur(s,i+1,j),recur(s,i,j-1));
        }


    }
}
