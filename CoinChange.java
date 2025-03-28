import java.util.Arrays;
/*
time complexity: O(n*sum)
space complexity: O(sum)
 */
public class CoinChange {
    int dp[] = new int[1000001];
    public int minCoins(int coins[], int sum) {
        // code here
        int n = coins.length;
        Arrays.fill(dp,-1);
        int soln = recur(coins,sum);
        if(soln==Integer.MAX_VALUE){
            return -1;
        }
        return soln;
    }
    public int recur(int coins[],int amount){
        int n = coins.length;
        int mini = Integer.MAX_VALUE;

        if(amount==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        for(int i=0;i<n;i++){
            int ans = recur(coins,amount-coins[i]);
            if(ans!=Integer.MAX_VALUE){
                mini=Math.min(mini,1+ans);
            }
        }
        return dp[amount]= mini;
    }
}
