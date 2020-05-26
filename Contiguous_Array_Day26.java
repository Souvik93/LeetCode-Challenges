/*

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

*/

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int max = 0;
        int s =0;
        hm.put(0,-1);
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                s= s-1;
            } else {
                s= s+1;
            }
            
            if(hm.containsKey(s)) {
                max = Math.max(max,i-hm.get(s));
            } else {
                hm.put(s,i);
            }
        }
        
        return max;
        
        
    }
}
