//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(String str, ArrayList<String> wordDict )
    {
        int strLen=str.length(), arrLen=wordDict.size();

        boolean[] dp=new boolean[strLen+1];

        dp[strLen]=true;
        
        for(int i=strLen-1; i>=0; i--) {
            for(int j=0; j<arrLen; j++) {
                if(i+wordDict.get(j).length()<=strLen && str.substring(i, i+wordDict.get(j).length()).equals(wordDict.get(j))) {
                    dp[i]=dp[i+wordDict.get(j).length()];
                }

                if(dp[i]) break;
            }
        }

        if(dp[0]) return 1;
        else return 0;
    }
}