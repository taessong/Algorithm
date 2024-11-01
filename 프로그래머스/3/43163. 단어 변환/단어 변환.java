class Solution {
    static int min = 987654321;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        int tmp = 0;  
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)) tmp++;
        }
        
        // 같은 문자가 없다면 0 return
        if(tmp == 0) return 0;
        
        DFS(begin, target, words, 0);
        return min;
    }
    
    public void DFS(String present, String target, String[] words, int count){
        if(present.equals(target)){
            if(count < min) min = count;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(check(present, words[i])){
                    DFS(words[i], target, words, count + 1);
                }
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String presentWord, String next){
        int tmp = 0;        
        for(int i = 0; i < presentWord.length(); i++){
            if(presentWord.charAt(i) != next.charAt(i)) tmp++;
        }
        
        // 변경 가능        
        if(tmp == 1) return true;
        return false;
    }
}