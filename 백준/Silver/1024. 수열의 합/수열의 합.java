import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        while(true) {
            // 등차수열의 합 공식을 이용해서 구한 첫째항
            int a = N / L - ((L - 1) / 2);
            if(a < 0 || L > 100) {
                System.out.println(-1);
                break;
            }

            // 등차수열의 합 공식
            int sum = L * (2 * a + (L - 1)) / 2;
            if(sum == N) {
                for(int i = 0; i < L; i++) {
                    System.out.print(a + i + " ");
                }
                break;
            }

            // 합이 N과 같지 않다면 L++
            L++;
        }
    }
}
