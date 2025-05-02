import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] heart = new int[2];
        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;
        boolean head = true;

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                char now = line.charAt(j);

                if(now == '_') continue;

                // 심장 위치 찾기
                if(head) {
                    heart[0] = i + 1;
                    heart[1] = j;
                    head = false;
                }

                if(heart[0] == i && heart[1] > j) leftArm++;
                if(heart[0] == i && heart[1] < j) rightArm++;
                if(heart[0] < i && heart[1] == j) waist++;
                if(heart[0] < i && heart[1] > j) leftLeg++;
                if(heart[0] < i && heart[1] < j) rightLeg++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        sb.append(leftArm + " ").append(rightArm + " ").append(waist + " ")
                .append(leftLeg + " ").append(rightLeg);

        System.out.println(sb);
    }
}
