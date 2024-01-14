//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    private int f(int ind,int total,int []cost,int [][]dp)
    {
        if(total<=0)
            return 0;
        if(ind==cost.length)
            return 0;
        if(dp[ind][total]!=-1)
            return dp[ind][total];
        int notTake=f(ind+1,total,cost,dp);
        int take=0;
        if(cost[ind]<=total)
        {
            take=1+f(ind+1,total-cost[ind]+(int)Math.floor(cost[ind]*0.9),cost,dp);
        }
        return dp[ind][total]=Math.max(take,notTake);
    }
    public int max_courses(int n, int total, int[] cost) {
        // code here
        int [][]dp=new int[n][total+1];
        for(int []val:dp)
            Arrays.fill(val,-1);
        return f(0,total,cost,dp);
    }
}
