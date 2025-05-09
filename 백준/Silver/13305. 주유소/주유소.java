import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] road = new long[N - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        long[] money = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            money[i] = Long.parseLong(st.nextToken());
        }

        long ans = road[0] * money[0];
        for(int i = 1; i < N - 1; i++) {
            // 직전 도시보다 기름값이 비싸다면 직전 도시 기름값으로 변경
            if(money[i] > money[i - 1]) money[i] = money[i - 1];
            ans += road[i] * money[i];
        }

        System.out.println(ans);
    }
}
