import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int r = 0, c = 0;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('E', 0);
        map.put('S', 1);
        map.put('W', 2);
        map.put('N', 3);
        
        int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
        
        for(int i = 0; i < routes.length; i++) {
            int dir = map.get(routes[i].charAt(0));
            int distance = routes[i].charAt(2) - '0';    
            int nr = r; int nc = c;
            
            int tmp = 0;
            while(tmp < distance) {
                nr += dr[dir];
                nc += dc[dir];
                
                if(nr < 0 || nr >= park.length || nc < 0 || nc >= park[0].length()) {
                    // 처음 자리로 초기화
                    nr = r;
                    nc = c;
                    break;
                }
                
                if(park[nr].charAt(nc) == 'X') {
                    nr = r;
                    nc = c;
                    break;
                }           
                
                tmp++;
            }
            
            r = nr; c = nc;
        }
        
        answer[0] = r;
        answer[1] = c;
        
        return answer;
    }
}