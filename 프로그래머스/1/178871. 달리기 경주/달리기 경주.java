import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
      
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            String name = callings[i];
            
            int rank = map.get(name);
            String tmp = players[rank - 1];
            players[rank - 1] = name;
            players[rank] = tmp;
            
            map.put(name, rank - 1);
            map.put(tmp, rank);
        }
        
        return players;
    }
}