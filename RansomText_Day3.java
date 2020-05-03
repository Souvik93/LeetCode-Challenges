/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        LinkedList<Character> ch = new LinkedList<>();
        for(int c=0 ; c<ransomNote.length() ; c++) {
            ch.add(ransomNote.charAt(c));
        }
        
        for(int d=0 ; d<magazine.length() ; d++) {
            if(ch.contains(magazine.charAt(d))) {
                ch.remove(Character.valueOf(magazine.charAt(d)));
            }
        }
        
        return ch.isEmpty();
        
    }
}
