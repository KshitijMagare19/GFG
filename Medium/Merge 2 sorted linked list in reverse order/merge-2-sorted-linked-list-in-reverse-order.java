//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node mergeResult(Node node1, Node node2) {
        if(node1 == null) return reverse(node2);
        if(node2 == null) return reverse(node1);
        
        return reverse(merge(node1, node2));
    }
    
    Node reverse(Node node) {
        Node prev = null, curr = node;
        
        while(curr != null) {
            Node fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        
        return prev;
    }
    
    Node merge(Node node1, Node node2) {
        Node p1 = node1, p2 = node2;
        Node ans = new Node(-1), prev = ans;
        
        while(p1 != null && p2 != null) {
            if(p1.data <= p2.data) {
                prev.next = p1;
                prev = p1;
                p1 = p1.next;
            } else {
                prev.next = p2;
                prev = p2;
                p2 = p2.next;
            }
        }
        
        while(p1 != null) {
            prev.next = p1;
            p1 = p1.next;
            prev = prev.next;
        }
        
        while(p2 != null) {
            prev.next = p2;
            p2 = p2.next;
            prev = prev.next;
        }
        
        return ans.next;
    }
}
