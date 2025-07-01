import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. 유저 ID를 index로 빠르게 찾을 수 있도록 매핑
        Map<String, Integer> idMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
        }

        // 2. 중복 신고 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        // 3. 신고당한 사람 기준으로 신고자 목록 저장
        Map<String, List<String>> reportedMap = new HashMap<>();
        for (String r : reportSet) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            reportedMap.putIfAbsent(reported, new ArrayList<>());
            reportedMap.get(reported).add(reporter);
        }

        // 4. 정지된 유저를 신고한 사람에게 메일 알림
        for (String reported : reportedMap.keySet()) {
            List<String> reporters = reportedMap.get(reported);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    int idx = idMap.get(reporter);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}
