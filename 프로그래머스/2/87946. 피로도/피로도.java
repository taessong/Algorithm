class Solution {
    static int size, max = -987654321;
    static boolean[] visited;
    static int[] go;
    
    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        visited = new boolean[size];
        go = new int[size];
        
        rotation(0, go, k, dungeons);
        return max;
    }
    
    public void rotation(int count, int[] go, int k, int[][] dungeons) {
        if(count == size) {
            int tired = dungeon(go, k, dungeons);
            if(max < tired) max = tired;
            return;
        }
        
        for(int i = 0; i < size; i++) {
            if(!visited[i]){
                visited[i] = true;
                go[count] = i;
                rotation(count + 1, go, k, dungeons);
                visited[i] = false;
            }
            else continue;
        }
    }
    
    public int dungeon(int[] go, int k, int[][] dungeons) {
        int count = 0;
        for(int i = 0; i < size; i++) {
            if(k >= dungeons[go[i]][0]) {
                k -= dungeons[go[i]][1];
                count++;
            }
        }
        return count;
    }
}