import java.util.*;

class Solution {
    
    public static int[][] adjArr;
    public static int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        // 인접행렬 생성
        adjArr = new int[info.length][info.length];
        
        // 무방향 그래프 생성
        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            
            adjArr[x][y] = 1;
            adjArr[y][x] = 1;
        }
  
        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, visited, info);
        
        return maxSheep;
    }
    
    public static void dfs(int currNode, int sheep, int wolf, boolean[] visited, int[] info) {
        if(info[currNode] == 0) sheep++;
        else wolf++;
        
        // 늑대가 양보다 같거나 많다면
        if(sheep <= wolf) return;
        
        // 방문 배열을 dfs마다 local로 관리해서 지나온 길을 다시 지나갈 수 있게 설정
        boolean[] newVisited = visited.clone();
        newVisited[currNode] = true;
        
        // 양 최대값 갱신
        maxSheep = Math.max(sheep, maxSheep);
        
        for(int i = 0; i < info.length; i++) {
            // 방문한 노드에서 연결된 리스트 확인
            if(newVisited[i]) {
                for(int j = 0; j < adjArr.length; j++) {
                    if(!newVisited[j] && adjArr[i][j] == 1) {
                        dfs(j, sheep, wolf, newVisited, info);
                    }
                }
            }
        }
    }
}