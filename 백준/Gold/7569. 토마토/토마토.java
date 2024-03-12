import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][][] arr; // 3차원 배열로 변경
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0, 0, 0}, dc = {0, 0, -1, 1, 0, 0}, dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M]; 

        for (int h = 0; h < H; h++) { // H번 반복
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    arr[h][r][c] = Integer.parseInt(st.nextToken());
                    if (arr[h][r][c] == 1) {
                        queue.offer(h); 
                        queue.offer(r);
                        queue.offer(c);
                    }
                }
            }
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        while (!queue.isEmpty()) {
            int ph = queue.poll(); 
            int pr = queue.poll();
            int pc = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nh = ph + dh[i];
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                
                if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (arr[nh][nr][nc] == 0) {
                        arr[nh][nr][nc] = arr[ph][pr][pc] + 1;
                        queue.offer(nh);
                        queue.offer(nr);
                        queue.offer(nc);
                    }
                }
            }
        }
        
        int max = -1;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (arr[h][r][c] == 0) return -1;
                    else if (arr[h][r][c] > max) max = arr[h][r][c];
                }
            }
        }

        if (max == 1) return 0;
        else return max - 1;
    }
}
