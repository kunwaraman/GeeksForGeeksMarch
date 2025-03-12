import java.util.*;
/*
time complexity: O(n)
space complexity: O(n)
 */
public class WayToReachNthStair {
    int dp[]= new int[46];
    int countWays(int n) {
        // your code here
        Arrays.fill(dp,-1);
        return recur(n);
    }
    int recur(int n){
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
}
