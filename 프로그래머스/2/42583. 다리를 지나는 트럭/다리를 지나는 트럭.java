import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        for(int i = 0; i < truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }
        
        while(!bridge.isEmpty()) {
            answer++;
            bridgeWeight -= bridge.poll();
            if(!trucks.isEmpty()) {
                if(bridgeWeight + trucks.peek() <= weight) {
                    bridge.offer(trucks.peek());
                    bridgeWeight += trucks.poll();
                }
                else {
                    bridge.offer(0);
                }
            }
        }
        
        
        return answer;
    }
}