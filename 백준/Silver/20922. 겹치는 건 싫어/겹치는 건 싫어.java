import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int left = 0, right = 0;
        int maxLen = 0;

        while(right < N) {
            count[nums[right]]++;

            // K 초과시 left 이동
            while(count[nums[right]] > K) {
                count[nums[left]]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        System.out.println(maxLen);
    }
}
