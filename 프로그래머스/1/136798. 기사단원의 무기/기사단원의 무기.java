class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int num = divNumber(i);
            
            if(num > limit) answer += power;
            else answer += num;
        }
        
        return answer;
    }
    
    public int divNumber(int num) {
        if(num == 1) return 1;
        
        int count = 0;
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                // 제곱근
                if(i * i == num) count += 1;
                else count += 2;
            }
        }
        
        return count;
    }
}