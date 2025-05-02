import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int goal;
        if(game.equals("Y")) goal = 1;
        else if(game.equals("F")) goal = 2;
        else goal = 3;

        HashSet<String> peoples = new HashSet<>();
        int canPlay = 0;

        for(int i = 0; i < N; i++) {
            int now = peoples.size();
            peoples.add(br.readLine());
            int plus = peoples.size();

            if(now != plus) {
                canPlay++;
                if(canPlay == goal) {
                    answer++;
                    canPlay = 0;
                }
            }
        }

        System.out.println(answer);
    }
}
