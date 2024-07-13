import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static class Pipe {
        int n;
        int right;
        int down;
        int cross;

        public Pipe(int n){
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Pipe[][] map = new Pipe[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = new Pipe(Integer.parseInt(st.nextToken()));
            }
        }

        // (0,1)부터 파이프 연결 시작할거임
        // (0,1)부분에는 오른쪽으로 온 파이프가 존재함
        map[0][1].right = 1;

        for(int r=0; r<N; r++){
            for(int c=2; c<N; c++){
                // 벽이면 넘어가
                if(map[r][c].n == 1) continue;

                // 오른쪽으로 가는 파이프
                map[r][c].right += map[r][c-1].right;
                map[r][c].right += map[r][c-1].cross;

                if(r>0){
                    // 아래로 가는 파이프
                    map[r][c].down += map[r-1][c].down;
                    map[r][c].down += map[r-1][c].cross;

                    if(map[r][c-1].n != 1 && map[r-1][c].n != 1){
                        // 대각선으로 가는 파이프
                        map[r][c].cross += map[r-1][c-1].right;
                        map[r][c].cross += map[r-1][c-1].down;
                        map[r][c].cross += map[r-1][c-1].cross;
                    }
                }
            }
        }
        System.out.println(map[N-1][N-1].cross + map[N-1][N-1].right + map[N-1][N-1].down);
    }
}