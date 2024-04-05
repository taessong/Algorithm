import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] shop;
    static int[] festival;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            // 출발 위치
            st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            // 편의점 위치
            shop = new int[n][2];
            boolean[] visited = new boolean[n]; // 방문 여부 배열
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                shop[i][0] = Integer.parseInt(st.nextToken());
                shop[i][1] = Integer.parseInt(st.nextToken());
            }

            // 축제 위치
            st = new StringTokenizer(br.readLine());
            festival = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            if (bfs(start, visited)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    public static boolean bfs(int[] start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (manhattan(now, festival) <= 1000) {
                return true; // 축제 위치에 도착한 경우
            } else {
                // 현재 위치에서 방문할 수 있는 편의점만 큐에 추가
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && manhattan(now, shop[i]) <= 1000) {
                        queue.offer(shop[i]);
                        visited[i] = true;
                    }
                }
            }
        }
        return false; // 축제 위치에 도착하지 못한 경우
    }

    public static int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
