import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                prices[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long profit = 0; // 부호 있는 64bit 정수형은 long

            // 뒤에서부터 순회하면서 이익을 구해주기
            // 새로운 최댓값 만나면 값 바꿔주기
            for(int j = N - 1; j >= 0; j--) {
                if(prices[j] > max) max = prices[j];
                else profit += max  - prices[j];
            }

            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}