import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24]; // 서버 증설 개수
        int[] expire = new int[24]; // 서버 만료 시간
        int currServer = 0; // 현재 서버 개수
        // 서버 증설 개수가 0이 아니고, expire이 0이라면 서버 개수 감소
        
        // 서버 증설할 때, server[i + k]에 미리 새롭게 생긴 서버 수를 마이너스 시켜놓는다?
        // 그리고 server[i] += server[i - 1] 이런식으로..
        
        for(int i = 0; i < 24; i++) {
            // 만료된 서버 삭제
            currServer -= expire[i];
            
            // 서버 증설이 필요 없다면 넘어가기
            if(players[i] < m) continue;
            
            // 새롭게 서버 증설하기
            int needServer = players[i] / m;
            if(needServer > currServer) {
                int newServer = needServer - currServer;
                server[i] = newServer;
                currServer = needServer;
                if(i + k < 24) expire[i + k] = newServer;
            }
        }
        
        // 정답
        int answer = 0;
        for(int i = 0; i < 24; i++) answer += server[i];
        return answer;
    }
}