/*

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/

class Solution {
    public String frequencySort(String s) {
        
        if(s.length()==1) {
            return s;
        }
        
        LinkedHashMap<Character,Integer> hm = new LinkedHashMap<>();
        
        for(int i=0;i<s.length();i++) {
            if(hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            } else {
                hm.put(s.charAt(i),1);
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> hm.get(b)-hm.get(a));
        pq.addAll(hm.keySet());
        
        while(!pq.isEmpty()) {
            Character c = pq.remove();
            for(int i= 0; i<hm.get(c);i++) {
                 sb.append(c);
            // str=str+ entry.getKey();
        }
        }
        

           return sb.toString();        
    }
}

