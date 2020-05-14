/*

Implement_Trie_Prefix_Tree_Day14.java By Souvik Das Inspired From https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/

public class TNode {
    TNode arr[];
    boolean isLast;
    TNode() {
        this.arr = new TNode[26];
    }
}
class Trie {
    
    private TNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TNode t = root;
        for(int i=0;i<word.length();i++) {
            int  c = word.charAt(i)-'a';
            if(t.arr[c]==null) {
                TNode p = new TNode();
                t.arr[c] = p;
                t= p;
            } else {
                t = t.arr[c];
            }
        }
        t.isLast = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TNode n = searchNode(word);
        if(n==null) {
            return false;
        } else {
            return n.isLast;
        }
        
    }
    
    public TNode searchNode(String word) {
        TNode p = root;
        for(int i=0;i<word.length();i++) {
            int c = word.charAt(i) -'a';
            if(p.arr[c]!=null) {
                p=p.arr[c];
            } else {
                return null;
            }
        }
        
        if(p==root) {
            return null;
        }
        return p;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TNode n = searchNode(prefix);
        if(n==null) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
