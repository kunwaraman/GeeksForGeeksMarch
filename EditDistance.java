public class EditDistance {
    int dp[][] = new int[1001][1001];
    public int editDistance(String s1, String s2) {
        // Code here
        int m = s1.length();
        int n = s2.length();
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }

        return recur(s1,s2,0,0);
    }
    public int recur(String s1,String s2,int i,int j){
        int m = s1.length();
        int n = s2.length();
        if(i==m){
            return n-j;
        }else if(j==n){
            return m-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= recur(s1,s2,i+1,j+1);
        }
        int insert=1+recur(s1,s2,i,j+1);
        int delete=1+recur(s1,s2,i+1,j);
        int replace=1+recur(s1,s2,i+1,j+1);

        return dp[i][j]= Math.min(insert,Math.min(delete,replace));



    }
}
