import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        String str = sc.next();

        char[] line = new char[N];
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            line[i] = str.charAt(i);
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(line[i] == 'P') {
                for(int j = i - K; j <= i + K; j++) {
                    // 범위를 벗어나면 넘어가기
                    if(j < 0 || j >= N) continue;

                    if(line[j] == 'H' && !visited[j]) {
                        visited[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
