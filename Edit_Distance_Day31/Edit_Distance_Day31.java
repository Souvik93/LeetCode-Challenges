/*

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


*/

class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        int mat[][] = new int[n+1][m+1];
        
        for(int i=0;i<mat.length;i++) {
            
            for(int j=0;j<mat[i].length;j++) {
                if(i==0) {
                    mat[i][j] = j;
                } else if(j==0) {
                    mat[i][j] = i;
                } else if(word1.charAt(j-1) == word2.charAt(i-1)) {
                    
                    mat[i][j] = mat[i-1][j-1];
                } else {
                    mat[i][j]= Math.min(Math.min(mat[i-1][j],mat[i-1][j-1]),mat[i][j-1])+1;
                }
            }
        }
        // print2DArray(mat);
         return mat[n][m];
    }
    
    public void print2DArray(int[][] arr) {
        for(int i =0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
                                          
}
