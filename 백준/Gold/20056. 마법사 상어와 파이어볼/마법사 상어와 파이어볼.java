import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 파이어볼을 이동시킨 후에 queue에 넣고
// 한사이클이 끝나고 queue에 있는 파이어볼을
// List에 넣어서 같은 r,c에 있는 파이어볼 개수 파악
public class Main {

    public static class FireBall {
        int r, c, m, s, d;

        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static FireBall[][] map;
    static Queue<FireBall> fireBallQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fireBallQueue = new LinkedList<>();

        // 최초 움직이는 파이어볼 큐에 넣기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBallQueue.offer(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            moveFireBalls();
            mergeAndDivideFireBalls();
        }

        int sum = 0;
        while (!fireBallQueue.isEmpty()) {
            sum += fireBallQueue.poll().m;
        }
        System.out.println(sum);
    }

    public static void moveFireBalls() {
        int size = fireBallQueue.size();
        for(int i = 0; i < size; i++) {
            FireBall fireBall = fireBallQueue.poll();
            int nr = (fireBall.r + fireBall.s * dr[fireBall.d]) % N;
            int nc = (fireBall.c + fireBall.s * dc[fireBall.d]) % N;

            // 음수값 처리
            if (nr < 0) nr += N;
            if (nc < 0) nc += N;

            fireBall.r = nr;
            fireBall.c = nc;
            fireBallQueue.offer(fireBall);
        }
    }

    public static void mergeAndDivideFireBalls() {
        List<FireBall>[][] fireBallList = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fireBallList[i][j] = new ArrayList<>();
            }
        }

        while(!fireBallQueue.isEmpty()) {
            FireBall fireBall = fireBallQueue.poll();
            fireBallList[fireBall.r][fireBall.c].add(fireBall);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 아무것도 없으면 스킵
                if(fireBallList[i][j].isEmpty()) continue;

                // 한개 있으면 그대로 queue에 넣기
                if(fireBallList[i][j].size() == 1) {
                    fireBallQueue.offer(fireBallList[i][j].get(0));
                }

                // 두개 이상이면 합치고 나누기
                else {
                    int sumMass = 0, sumSpeed = 0, count = fireBallList[i][j].size();
                    boolean allEven = true, allOdd = true;

                    for(FireBall fireBall : fireBallList[i][j]) {
                        sumMass += fireBall.m;
                        sumSpeed += fireBall.s;
                        if(fireBall.d % 2 == 0) allOdd = false;
                        else allEven = false;
                    }

                    int newMass = sumMass / 5;
                    // 질량이 0이면 소멸
                    if(newMass == 0) continue;

                    int newSpeed = sumSpeed / count;
                    int[] directions;
                    if(allEven || allOdd) {
                        directions = new int[]{0, 2, 4, 6};
                    }
                    else {
                        directions = new int[]{1, 3, 5, 7};
                    }

                    for(int d : directions){
                        fireBallQueue.offer(new FireBall(i, j, newMass, newSpeed, d));
                    }
                }
            }
        }
    }
}