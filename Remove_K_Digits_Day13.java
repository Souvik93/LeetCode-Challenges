/*

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

*/

class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num.length() == k) {
            return "0";
        }
        
        if(k==0) {
            return num;
        }
        
       /* Stack<Character>  s = new Stack<>();
        
        for(int i=0;i<num.length();i++) {
            Character c = num.charAt(i);
            
            while(!s.isEmpty() && k > 0 && s.peek()>c) {
                s.pop();
                // s.push(c);
                System.out.println("Inside If Block"+s);
                
                System.out.println("Inside If Block 2"+c);
                
                k--;
            }
            
               s.push(c);
    
            System.out.println("Inside For Loop Outside If Block 2"+s);
        }
               
       while(k>0) {
           s.pop();
           k--;
           System.out.println("Inside While Loop"+s);
       }
               
    StringBuilder b = new StringBuilder();
        
    while(!s.isEmpty()) {
        b.append(s.pop());
    }
        
        b.reverse(); */
        
        StringBuilder b = new StringBuilder(num);
        
        for(int j=0;j<k;j++) {
            int i=0;
            while(i<b.length()-1 && b.charAt(i)<=b.charAt(i+1)) {
                i++;
               
            }
             b.deleteCharAt(i);
            
        }
        
        while(b.length()>1 && b.charAt(0) == '0') {
            b.deleteCharAt(0);
        }
        
        return b.toString();
        
    }
}
