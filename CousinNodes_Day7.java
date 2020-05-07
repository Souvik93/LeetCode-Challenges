/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
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
class Solution {
    static int counter = 0;
    static int parent = 0;
    
    
    
    class SearchedNode{
        
        int level;
        TreeNode parent;
        
        SearchedNode(int level,TreeNode parent) {
            this.level = level;
            this.parent = parent;
        }
        
        
    }
    
    public SearchedNode search(TreeNode tn, TreeNode p, int level, int val) {
        if(tn==null) {
            return null;
        }
        if(tn.val== val) {
            return new SearchedNode(level,p);
        }
        
        SearchedNode l = search(tn.left,tn,level+1,val);
        SearchedNode r = search(tn.right,tn,level+1,val);
        
        if(l==null) {
            return r;
        } else {
            return l;
        }
        
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        // System.out.println("Hey There !!"+root.left.left.val);
        
        
        SearchedNode l = search(root,null,0,x);
        SearchedNode r = search(root,null,0,y);
        
        return ((l.parent != r.parent) && (l.level == r.level));
        
        
    }
    
    public int level(TreeNode tn, int key, int level) {
          System.out.println("Hey Insde Level"+tn);
         // System.out.println("Hey Insde Parent "+ Solution.parent);
        if(tn == null) {
            return 0;
        } 
        
        System.out.println("Hey Insde Level"+tn.val);
        
        if(tn.val == key) {
            return level;
        }
        Solution.parent = tn.val;
        int l = level(tn.left,key,level+1);
        
        if(l!=0) {
            return l;
        }
        Solution.parent = tn.val;
        return level(tn.right,key,level+1);
    }
    
    public boolean isSiblings(TreeNode tn,int key1, int key2) {
        if(tn==null) {
            return false;
        }
        if(tn.left==null || tn.right==null) {
            return false;
        }
        return ((tn.left.val==key1 && tn.right.val==key2) || (tn.left.val == key2 && tn.right.val == key1 )
                || isSiblings(tn.left,key1,key2) || isSiblings(tn.right,key1,key2));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean ifNodeExist(TreeNode treeNode, int child) {
        
        
        if(treeNode == null) {
            return false;
        }
        
        Solution.counter++;
        
        if(treeNode.val==child) {
            return true;
        }
        Solution.parent = treeNode.val;
        boolean res1 = ifNodeExist(treeNode.left,child);
        if(res1) {
            return true;
        }
        
        boolean res2 = ifNodeExist(treeNode.right,child);
        return res2;
        
    }
    
    public int leftHeight(TreeNode root, int x) {
        int lPar = root.val;
        int counter = 1;
        while(root.left != null) {
            
            if(root.val == x) {
                return counter;
            }
            
            counter++;
            root = root.left;
            
        }
        
        return counter;
    }
}
