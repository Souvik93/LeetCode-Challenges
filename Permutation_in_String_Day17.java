/*

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
   Hide Hint #1  
Obviously, brute force will result in TLE. Think of something else.
   Hide Hint #2  
How will you check whether one string is a permutation of another string?
   Hide Hint #3  
One way is to sort the string and then compare. But, Is there a better way?
   Hide Hint #4  
If one string is a permutation of another string then they must one common metric. What is that?
   Hide Hint #5  
Both strings must have same character frequencies, if one is permutation of another. Which data structure should be used to store frequencies?
   Hide Hint #6  
What about hash table? An array of size 26?


*/


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) {
            return false;
        }
        
        int s1Arr[] = new int[26];
        int s2Arr[] = new int[26];
        
        for(int i=0;i<s1.length();i++) {
            
            s1Arr[s1.charAt(i)-'a']++;
            s2Arr[s2.charAt(i)-'a']++;
            
        }
        
        for(int i=0;i<s2.length()-s1.length();i++) 
            {
            if(matches(s1Arr,s2Arr)){
                return true;
            }
            s2Arr[s2.charAt(i)-'a']--;
            s2Arr[s2.charAt(i+s1.length())-'a']++;
            
        }
            
            if(matches(s1Arr,s2Arr)){
                return true;
            } else{
                return false;
            }
        
        
        
    
    }
    
    public boolean matches(int arr1[],int arr2[]) {
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
