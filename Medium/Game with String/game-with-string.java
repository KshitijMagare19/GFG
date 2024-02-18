//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );
        Map<Character, Integer> um = new HashMap<>();

        for (char xx : s.toCharArray()) {
            um.put(xx, um.getOrDefault(xx, 0) + 1);
        }

        pq.addAll(um.entrySet());

        while (k-- > 0) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int count = entry.getValue();
            if (count > 1) {
                pq.add(Map.entry(entry.getKey(), count - 1));
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int t = entry.getValue();
            ans += (t * t);
        }

        return ans;
    }
}