class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        
        for(int i = s.length() - 1; i >= 1; i--) {
            int idx = i - 1;
            while(idx >= 0) {
                if(s.charAt(idx) == s.charAt(i)) {
                    answer[i] = i - idx;
                    break;
                };
                idx--;
            }
        }
        
        return answer;
    }
}