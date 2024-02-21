//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int mod = (int)(1e9 + 7);
    int  subsequenceCount(String S, String T)
    {
        
	    int N = S.length();	
	    int M = T.length();	
	    
	    int dp[][] = new int[N+1][M+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return count(N , M , S , T , dp)%mod;
	    
    }
    int count(int n , int m , String s , String t , int dp[][]){

        if(m == 0) return 1;
        if(n == 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(s.charAt(n-1) == t.charAt(m-1)) {
            return dp[n][m] = ( count(n-1 , m-1 , s , t , dp) + count(n-1 , m , s , t , dp) ) % mod;
        }

        return dp[n][m] = ( count(n-1 , m , s , t , dp) ) % mod;
    }
}