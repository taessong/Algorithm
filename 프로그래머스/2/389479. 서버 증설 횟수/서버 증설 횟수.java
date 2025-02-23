import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24]; // 서버 증설 개수
        int[] expire = new int[24]; // 서버 만료 시간
        int currServer = 0; // 현재 서버 개수
        
        for(int i = 0; i < 24; i++) {
            // 만료된 서버 삭제
            currServer -= expire[i];
            
            // 서버 증설이 필요 없다면 넘어가기
            if(players[i] < m) continue;
            
            // 새롭게 서버 증설하기
            // 새롭게 필요한 서버 수
            int needServer = players[i] / m;
            // 필요한 서버 수가 현재 서버보다 많다면
            if(needServer > currServer) {
                // 생성해야 하는 서버 개수
                int newServer = needServer - currServer;
                // 서버 증설 배열에 저장
                server[i] = newServer;
                // 현재 서버 개수 업데이트
                currServer = needServer;
                // 서버 만료 시간(k)에 서버 개수 저장
                if(i + k < 24) expire[i + k] = newServer;
            }
        }
        
        // 정답
        int answer = 0;
        for(int i = 0; i < 24; i++) answer += server[i];
        return answer;
    }
}
