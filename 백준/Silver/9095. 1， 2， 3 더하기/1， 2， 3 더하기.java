import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // F(n) = F(n-1) + F(n-2) + F(n-3)
        // n이 음수라면 return 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(F(n)).append("\n");
        }
        System.out.println(sb);
    }

    public static int F(int n) {
        if(n <= 0) return 0;

        if(n == 1) return 1;

        if(n == 2) return 2;

        if(n == 3) return 4;

        return F(n - 1) + F(n - 2) + F(n - 3);
    }
}