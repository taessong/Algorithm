class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        // dfs
        // 먼저 plus로 돌리고 끝까지 plus를 붙혔다면 minus 시작
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int calc) {
        // 탈출
        if(depth == numbers.length){
            if(calc == target){
                answer++;
            }
            return;
        }
        
        // 반복
        dfs(numbers, target, depth + 1, calc + numbers[depth]);
        dfs(numbers, target, depth + 1, calc - numbers[depth]);
    }
}