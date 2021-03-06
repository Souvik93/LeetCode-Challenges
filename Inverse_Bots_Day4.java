/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to o
*/

class Solution {
    public int findComplement(int num) {
        
        int totalBits = (int)(Math.floor(Math.log(num) / Math.log(2))) + 1; 
    return (int)(Math.pow(2, totalBits)-1) ^ num; 
        
    }
}
