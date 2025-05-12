import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int time = 0, bridgeWeight = 0;

        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        while(!bridge.isEmpty()) {
            time++;
            bridgeWeight -= bridge.poll();
            if(!trucks.isEmpty()) {
                // 다리에 트럭이 올라갈 수 있다면
                if(bridgeWeight + trucks.peek() <= L) {
                    bridge.offer(trucks.peek());
                    bridgeWeight += trucks.poll();
                }
                // 올라갈 수 없다면
                else {
                    bridge.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}
