//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        int M = 1000000007;
        long take = 1, notTake = 1;
        
        for(int i=1; i<N; i++) {
            long newTake = notTake;
            long newNotTake = (newTake + take)%M;
            
            take = newTake;
            notTake = newNotTake;
        }
        long oneSideWay = (take+notTake)%M;
        return (int)((oneSideWay*oneSideWay)%M);
    }
}