class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 0; i < skip.length(); i++) {
            char nSkip = skip.charAt(i);
            alphabet = alphabet.replace(String.valueOf(nSkip), "");
        }
        
        int size = alphabet.length();
        
        for(int i = 0; i < s.length(); i++) {
            char nS = s.charAt(i);
            int jIdx = 0;
            
            for(int j = 0; j < size; j++) {
                if(nS == alphabet.charAt(j)) jIdx = j;
            }
            
            jIdx = (jIdx + index) % size;
            answer += String.valueOf(alphabet.charAt(jIdx));
        }
        
        return answer;
    }
}