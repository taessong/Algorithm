import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    static int R,C,N;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }
        
        // 경비원
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int move = Integer.parseInt(st.nextToken());
        
        findMin(dir, move);
        System.out.println(result);
    }
    
    public static void findMin(int dir, int move) {
        for(int n=0; n<N; n++) {
            // 경비원이 남, 북
            if(dir == 1 || dir == 2) {
                // 같은 방향
                if(arr[n][0] == dir) {
                    result += Math.abs(move-arr[n][1]);
                } else if(arr[n][0] == 1 || arr[n][0] == 2) {
                    // 반대 방향 && 시계 방향
                    int a = move + arr[n][1] + C;
                    int b = (R-move) + C + (R-arr[n][1]);
                    if(a>b) result += b;
                    else result += a;
                } else {
                    if(arr[n][0] == 3 && dir == 2) {
                        result += move + (C-arr[n][1]);
                    } else if(arr[n][0] == 4 && dir == 2) {
                        result += (R-move) + (C-arr[n][1]);
                    } else if(arr[n][0] == 3 && dir == 1) {
                        result += move + arr[n][1];
                    } else if(arr[n][0] == 4 && dir == 1) {
                        result += (R-move) + arr[n][1];
                    }
                }
            } else { // 경비원이 동, 서
                // 같은 방향
                if(arr[n][0] == dir) {
                    result += Math.abs(move-arr[n][1]);
                } else if(arr[n][0] == 3 || arr[n][0] == 4) {
                    // 반대 방향 && 시계 방향
                    int a = move + arr[n][1] + R;
                    int b = (C-move) + R + (C-arr[n][1]);
                    if(a>b) result += b;
                    else result += a;
                } else {
                    if(arr[n][0] == 1 && dir == 3) {
                        result += move + arr[n][1];
                    } else if(arr[n][0] == 2 && dir == 3) {
                        result += (C-move) + arr[n][1];
                    } else if(arr[n][0] == 1 && dir == 4) {
                        result += move + (R-arr[n][1]);
                    } else if(arr[n][0] == 2 && dir == 4) {
                        result += (C-move) + (R-arr[n][1]);
                    }
                }
            }
        }
    }
}