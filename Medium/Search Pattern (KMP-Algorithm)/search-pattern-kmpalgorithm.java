//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        int pL=pat.length();
        int sL=S.length();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<sL;i++){
            
           if(S.charAt(i)==pat.charAt(0)){
               int count=1;
               int k=i+1;
               int j=1;
               while(k<sL && j<pL && S.charAt(k)==pat.charAt(j)){
                   k++;
                   j++;
                   count++;
               }
               if(count==pL) arr.add(i+1);
           }
        }
        if(arr.size()==0) arr.add(-1);
        return arr;
        
    }
}