class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int[] bricks = new int[n];
        for(int i = 0; i < section.length; i++) {
            bricks[section[i] - 1] = 1;
        }
        
        for(int i = 0; i < n; i++) {
            if(bricks[i] == 1) {
                for(int j = 0; j < m; j++) {
                    if(i + j == n) break;
                    
                    bricks[i + j] = 0;
                }
                answer++;
            }
        }
        
        return answer;
    }
}