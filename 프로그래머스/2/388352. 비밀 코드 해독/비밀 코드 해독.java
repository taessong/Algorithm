import java.util.*;

class Solution {
    
    public static int N, Q, answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n; Q = q.length;
        int[] nums = new int[5];
        
        combination(q, ans, nums, 0, 1);
        
        return answer;
    }
    
    public static void combination(int[][] q, int[] ans, int[] nums, int count, int idx) {
        if(count == 5) {
            int sum = 0;
            for(int i = 0; i < Q; i++) {
            // HashSet을 이용해서 중복된 값 (같은 값) 제거
            HashSet<Integer> set = new HashSet<>();
                
                for(int j = 0; j < 5; j++) {
                    set.add(nums[j]);
                    set.add(q[i][j]);
                }
                // 중복된 값(same)이 ans[i]와 같다면 sum++
                int same = 10 - set.size();
                if(same == ans[i]) sum++;
            }
            // sum이 ans.length와 같아면 answer++
            if(sum == ans.length) answer++;
            return;
        }
        
        if(idx == N + 1) return;
        
        combination(q, ans, nums, count, idx + 1);
        
        nums[count] = idx;
        combination(q, ans, nums, count + 1, idx + 1);
    }
}