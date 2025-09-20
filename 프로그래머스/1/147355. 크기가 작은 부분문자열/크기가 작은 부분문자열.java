class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pLong = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            // substring()으로 p의 길이만큼 부분 문자열 추출
            String num = t.substring(i, i + p.length());
            long numLong = Long.parseLong(num); // 부분 문자열을 long으로 변환

            if (numLong <= pLong) {
                answer++;
            }
        }
        return answer;
    }
}