import java.util.*;

class Solution {
    
    public static class Robot{
        int r;
        int c;
        
        Robot(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        public void moveRToTarget(int targetR) {
            if(r < targetR) r++;           
            else if (r > targetR) r--;
        }
        
        public void moveCToTarget(int targetC) {
            if(c < targetC) c++;           
            else if (c > targetC) c--;
        }
        
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Set<String> checkSet = new HashSet<>();
        Set<String> collisionSet = new HashSet<>();
        String loc;
        int time, beforeSize, rDiff, cDiff;
        
        for(int i = 0; i < routes.length; i++) {
            int startPoint = routes[i][0] - 1;
            int endPoint = routes[i][1] - 1;
            
            time = 0;
            loc = Integer.toString(time) + "-" + Integer.toString(points[startPoint][0]) + "-" + Integer.toString(points[startPoint][1]); // 시간-r-c
            
            beforeSize = checkSet.size();
            checkSet.add(loc);
            
            // checkSet에 값을 추가했을 때, 크기가 변하지 않는다면 충돌이 일어난 것임
            if(beforeSize == checkSet.size()) collisionSet.add(loc);
            
            for(int j = 1; j < routes[i].length; j++) {
                Robot robot = new Robot(points[routes[i][j - 1] - 1][0], points[routes[i][j - 1] - 1][1]);
                
                rDiff = Math.abs(points[routes[i][j - 1] - 1][0] - points[routes[i][j] - 1][0]);
                cDiff = Math.abs(points[routes[i][j - 1] - 1][1] - points[routes[i][j] - 1][1]);
                // System.out.println(points[routes[i][j - 1] - 1][0]);
                // System.out.println(points[routes[i][j] - 1][0]);
                // System.out.println(rDiff);

                for(int k = 0; k < rDiff; k++){
                    // if(robot.r == points[endPoint][0]) break;
                    
                    robot.moveRToTarget(points[routes[i][j] - 1][0]);
                    loc = "";
                    time++;
                    
                    loc = Integer.toString(time) + "-" + Integer.toString(robot.r) + "-" + Integer.toString(robot.c);
                    // System.out.println(loc);
                    beforeSize = checkSet.size();
                    checkSet.add(loc);
                    
                    if(beforeSize == checkSet.size()) collisionSet.add(loc);
                }
                
                for(int k = 0; k < cDiff; k++){
                    // if(robot.c == points[endPoint][1]) break;
                    
                    robot.moveCToTarget(points[routes[i][j] - 1][1]);
                    loc = "";
                    time++;
                    
                    loc = Integer.toString(time) + "-" + Integer.toString(robot.r) + "-" + Integer.toString(robot.c);
                    
                    beforeSize = checkSet.size();
                    checkSet.add(loc);
                    
                    if(beforeSize == checkSet.size()) collisionSet.add(loc);
                }
            }
        }
        answer = collisionSet.size();
        return answer;
    }
    
    
    
}