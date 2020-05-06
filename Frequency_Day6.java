/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/

class Solution {
    public int majorityElement(int[] nums) {
        
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0;i<nums.length;i++) {
            if(tm.containsKey(nums[i])) {
                tm.put(nums[i],tm.get(nums[i])+1);
            } else {
                 tm.put(nums[i],1);
            }
        }
        int max=0;
        int no = 0;
        // Set<Entry<Integer,Integer>> entrySet =tm.entrySet();
        
        for(Map.Entry<Integer,Integer> entry: tm.entrySet()) {
            if(entry.getValue()>max) {
                max = entry.getValue();
                no = entry.getKey();
            }
        }
        return no;
    }
