//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean cmp(int mid,int arr[],int N,int K){
        int count=1;
        int sum=0;
        for(int i=0;i<N;i++){
            if(arr[i]>mid) return true;
            else if(arr[i]+sum<=mid){
                sum+=arr[i];
            }
            else{
                sum=arr[i];
                count++;
            }
        }
        if(count<=K) return false;
        return true;
    }
    int splitArray(int arr[] ,int N, int K) {
        // code here
        int sum=0;
        for(int i=0;i<N;i++) sum+=arr[i];
        int l=0,h=sum;
        while(h-l>1){
            int mid=(h+l)/2;
            if(cmp(mid,arr,N,K)){
                l=mid;
            }
            else{
                h=mid;
            }
        }
        return h;
    }
};