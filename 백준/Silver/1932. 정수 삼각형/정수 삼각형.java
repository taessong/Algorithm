import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] result = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i + 1; j++){
                if(result[i][j] != 0 && i != N - 1){
                    if(result[i + 1][j] < result[i][j] + map[i + 1][j]){
                        result[i + 1][j] = result[i][j] + map[i + 1][j];
                    }
                    result[i + 1][j + 1] = result[i][j] + map[i + 1][j + 1];
                }
            }
        }

        int max = 0;
        for(int j = 0; j < N; j++){
            max = Math.max(result[N-1][j], max);
        }
        System.out.println(max);
    }
}