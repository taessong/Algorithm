class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // abcde fghij klmno pqrst uvwxy z
        int[] alphabet = new int[26];
        for(int i = 0; i < alphabet.length; i++) alphabet[i] = 101;
        
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                int idx = keymap[i].charAt(j) - 'A';
                if(j < alphabet[idx]) alphabet[idx] = j;
            }
        }
        
        int ansIdx = 0;
        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean check = false;
            for(int j = 0; j < targets[i].length(); j++) {
                int idx = targets[i].charAt(j) - 'A';
                
                if(alphabet[idx] == 101) check = true; 
                sum += alphabet[idx] + 1;
            }
            if(check) answer[ansIdx++] = -1;
            else answer[ansIdx++] = sum;
        }
        
        return answer;
        
    }
}