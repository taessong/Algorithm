import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 하정수 인스타 삭제해라
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int network = 0;
        
        // queue.offer(0);
        // visited[0] = true;
        //아하
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) queue.offer(i);
            
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                
                for(int j = 0; j < computers[curr].length; j++) {
                    if(i == j) continue;
                    
                    if(!visited[j] && computers[curr][j] == 1) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            if(queue.isEmpty()) network++;
            }
            
            
            // network++;
        }
        
        return network;
    }
}