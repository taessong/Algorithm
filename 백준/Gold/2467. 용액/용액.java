import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] fluids = new int[n];
        int min = Integer.MAX_VALUE;
        int high, low, selected;
        int[] answers = new int[2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            fluids[i] = Integer.parseInt(st.nextToken());
        }

        // n개의 값을 순환하면서
        // 그 수와 하나의 값을 비교, 이분 탐색 진행
        for(int i = 0; i < n; i++){
            selected = i;
            low = selected + 1;
            high = n - 1;

            while(low <= high){
                int mid = (low + high) / 2;
                int tmp = fluids[selected] + fluids[mid];

                // 0에 가깝다면 현재 selected, mid 업데이트
                if(Math.abs(tmp) < min){
                    min = Math.abs(tmp);
                    answers[0] = fluids[selected];
                    answers[1] = fluids[mid];
                }

                // 합이 음수면 나눈 값의 오른쪽 탐색
                if(tmp < 0) low = mid + 1;
                // 양수면 왼쪽 탐색
                else high = mid - 1;
            }
        }
        System.out.println(answers[0] + " " + answers[1]);
    }
}