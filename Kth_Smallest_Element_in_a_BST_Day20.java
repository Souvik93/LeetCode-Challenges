/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

   Hide Hint #1  
Try to utilize the property of a BST.
   Hide Hint #2  
Try in-order traversal. (Credits to @chan13)
   Hide Hint #3  
What if you could modify the BST node's structure?
   Hide Hint #4  
The optimal runtime complexity is O(height of BST).

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*class Solution {
    public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    while(p!=null){
        stack.push(p);
        p=p.left;
    }
    int i=0;
    while(!stack.isEmpty()){
        TreeNode t = stack.pop();
        i++;
 
        if(i==k)
            return t.val;
 
        TreeNode r = t.right;
        while(r!=null){
            stack.push(r);
            r=r.left;
        }
 
    }
 
    return -1;
}
}*/

class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
     int num[] = new int[2];
     inOrder(root,k,num);
     return num[1];
    }
    
    public void inOrder(TreeNode root,int k, int nums[]) {
        
        if(root == null) {
            return;
        }
        
        inOrder(root.left,k,nums);
        
        if(++nums[0]==k) {
            nums[1]=root.val;
            return;
        }
        
        inOrder(root.right,k,nums);
        
    }
}


