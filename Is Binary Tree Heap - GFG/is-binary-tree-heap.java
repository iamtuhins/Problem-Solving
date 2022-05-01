// { Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

  public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    boolean isHeap(Node tree) {
        // code here
        int n=count(tree);
        if(isComplete(tree,0,n) && isOrder(tree)){
            return true;
        }
        return false;
    }
    boolean isOrder(Node tree){
        if(tree.left==null && tree.right==null){
            return true;
        }
        int temp=tree.data;
        if(tree.right==null){
            return (temp>=tree.left.data);
        }
        boolean lf=isOrder(tree.left);
        boolean rt=isOrder(tree.right);
        if(temp>=tree.left.data && temp>=tree.right.data && lf && rt){
            return true;
        }
        return false;
        
    }
    boolean isComplete(Node tree,int id,int count){
        if(tree==null){
            return true;
        }
        if(id>=count){
            return false;
        }
        boolean lf=isComplete(tree.left,(id*2)+1,count);
        boolean rt=isComplete(tree.right,(id*2)+2,count);
        return (lf&&rt);
    }
    int count(Node tree){
        if(tree==null){
            return 0;
        }
        int lf=count(tree.left);
        int rt=count(tree.right);
        return 1+(lf+rt);
    }
}