class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return binarySearch(diffs, times, limit);
    }   
    
    public int binarySearch(int[] diffs, int[] times, long limit){
        int min = 1;
        int max = 100000;
        while(min <= max){
            int level = (min + max) / 2;
            long answer = calculation(diffs, times, level);
            if(answer <= limit) max = level - 1;
            else if (answer > limit) min = level + 1;
        }
        return min;
    }
    
    public long calculation(int[] diffs, int[] times, int level){
        long answer = 0;
        for(int i = 0; i < diffs.length ; i++){
            if(diffs[i] <= level) {
                answer += times[i];
            }
            else {
                answer += (diffs[i] - level) * (times[i-1] + times[i]) + times[i];
            }
        }
        return answer;
    }
}
