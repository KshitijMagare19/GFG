#User function Template for python3

class Solution:
    def recamanSequence(self, n):
        arr =[0] * n
        lst=set([0])
        if n>0:
            for i in range(1,n):
                arr[i]=arr[i-1]-i
                if arr[i]<0 or (arr[i] in lst):
                    arr[i]=arr[i-1]+i
                lst.add(arr[i])
        return arr

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        
        ob = Solution()
        ans = ob.recamanSequence(n)
        for i in range(n):
            print(ans[i],end=" ")
        print()
# } Driver Code Ends