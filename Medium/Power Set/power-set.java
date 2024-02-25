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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
     static void powerSet(String s, int idx, int n, StringBuilder str, List<String> ans) 
    {
        if (idx == n) {
            
            String currentString = str.toString().trim(); // Mandatory Line for removing whiteSpaces
            if (!currentString.isEmpty()) {
                ans.add(currentString);
            }
            return;
        }

        str.append(s.charAt(idx));
        powerSet(s, idx + 1, n, str, ans);
        str.deleteCharAt(str.length() - 1);

        powerSet(s, idx + 1, n, str, ans);
    }

    public List<String> AllPossibleStrings(String s) {
        
        List<String> ans = new ArrayList<>();
        int n = s.length();
        StringBuilder str = new StringBuilder();

        powerSet(s, 0, n, str, ans);
        
        //Collections.sort(ans); --> Working
        Collections.sort(ans, String.CASE_INSENSITIVE_ORDER); //  --> Working in all case
        return ans;
    }
}