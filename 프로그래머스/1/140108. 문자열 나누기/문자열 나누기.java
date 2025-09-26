class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int sum = 0;
        char x = 'a';
        for(int i = 0; i < s.length(); i++) {
            if(i == s.length() - 1) break;
            
            char tmp = s.charAt(i);
            
            if(sum == 0) {
                x = tmp;
                sum++;
                continue;
            }
            
            if(x == tmp) sum++;
            else {
                sum--;
                if(sum == 0) answer++;
            }
        }
        
        return answer + 1;
    }
}