import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int network = 0;
        
        visited[0] = true;
        queue.offer(0);
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) queue.offer(i);
            
            // 인접한 네트워크 찾는 while문
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
        }
        return network;
    }
}
