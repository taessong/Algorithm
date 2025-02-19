import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, min = 987654321;
    static int[] peoples, areas;
    static boolean[] visited;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
        areas = new int[N + 1];
        list = new List[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new LinkedList<>();

            int iter = Integer.parseInt(st.nextToken());
            for (int j = 0; j < iter; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dividePeoples(1);
        if(min == 987654321) System.out.println(-1);
        else System.out.println(min);
    }

    // 선거구 할당
    public static void dividePeoples(int idx) {
        // 모든 지역 다 뽑았다면
        if(idx == N + 1) {
            // 인구수 차이와 min 비교
            int diff = diffPeoples();
            
            // 차이가 min보다 더 작다면
            if(diff < min) {
                // 이제 나뉘어진 구역끼리 연결되었는지 확인
                visited = new boolean[N + 1];
                int link = 0;

                for(int i = 1; i < N + 1; i++) {
                    if(!visited[i]) {
                        linkedCheck(i, areas[i]);
                        link++;
                    }
                }
                // link가 2면 선거구가 2개로 나뉜 것
                // 1이면 하나의 선거구가 존재하는 것이고, 3 이상이면 나뉘어진 선거구끼리 연결이 되지 않은 상태
                if(link == 2) min = diff;
            }
            return;
        }

        // 1번 지역
        areas[idx] = 1;
        dividePeoples(idx + 1);

        // 2번 지역
        areas[idx] = 2;
        dividePeoples(idx + 1);
    }

    // 인구수 차이 구하는 메서드
    public static int diffPeoples() {
        int sum1 = 0; // A구역 인구수
        int sum2 = 0; // B구역 인구수

        for(int i = 1; i < N + 1; i++) {
            if(areas[i] == 1) sum1 += peoples[i];
            else sum2 += peoples[i];
        }

        return Math.abs(sum1 - sum2);
    }

    // 연결된 도시 체크
    public static void linkedCheck(int idx, int areaNum) {
        Queue<Integer> queue = new LinkedList<>();
        visited[idx] = true;
        queue.offer(idx);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                // 방문하지 않았고, 같은 선거구라면
                if(!visited[next] && areas[next] == areaNum) {
                   visited[next] = true; // 방문처리
                   queue.offer(next); // queue에 넣어 인접한 도시 체크
                }
            }
        }
    }
}