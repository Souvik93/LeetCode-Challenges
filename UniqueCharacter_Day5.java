/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        if(s.length()<=0) {
            return -1;
        }
        if(s.length() == 1) {
            return 0;
        }
        
        int last = s.length();
        
        for(int i=0;i<last;i++) {
            String str;
            if(i==last-1) {
                str = s.substring(0,i);
            }
            else {
                str = s.substring(0,i) + s.substring(i+1);
            }
            
            if(!str.contains(s.charAt(i)+"")) {
                return i;
            }
        }
        
        return -1;
        
    }
}

