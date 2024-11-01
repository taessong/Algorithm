import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int get = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        if(set.size() < get) return set.size();
        else return get;
    }
}