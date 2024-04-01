import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, score, max = Integer.MIN_VALUE;
    static int[] base, order, visited;
    static int[][] player;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        base = new int[4];
        player = new int[N+1][10];
        order = new int[10];
        visited = new int[10];
        
        for(int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<10; i++) {
                player[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited[4] = 1;
        order[4] = 1; // 1번 선수
        
        baseball(2);
        System.out.println(max);
    }
    
    public static void baseball(int num) {
        if(num == 10) {
            score();
            return;
        }
        
        for(int i=1; i<10; i++) {
            if(visited[i] == 1) continue;      
            
            // order에 몇번 선수인지 넣어주기
            order[i] = num;
            visited[i] = 1;
            baseball(num+1);
            visited[i] = 0;
        }
    }
    
    public static void score() {
        int start = 1;
    	
        for(int n=1; n<=N; n++) {
        	int out = 0;
        	// 베이스 초기화
        	base = new int[4];
        	
        	loop : while(true) {
        		for(int i=start; i<10; i++) {
        			// 아웃
        			if(player[n][order[i]] == 0) {
        				out++;
        				// 3아웃이면 다음 타자로 넘어가고 break
        				if(out == 3) 	{
        					start = i+1;
        					break loop;
        				}
        			}
        			
        			// 안타
        			else if(player[n][order[i]] == 1) {
        				// 3루에 있었다면
        				if(base[3] == 1) {
        					base[3]--;
        					score++;
        				}
        				// 2루에 있었다면
        				if(base[2] == 1) {
        					base[2]--;
        					base[3]++;
        				}
        				if(base[1] == 1) {
        					base[1]--;
        					base[2]++;
        				}
        				// 1루 채우기
        				base[1]++;
        			}
        			
        			// 2루타
        			else if(player[n][order[i]] == 2) {
        				// 3루에 있었다면
        				if(base[3] == 1) {
        					base[3]--;
        					score++;
        				}
        				// 2루에 있었다면
        				if(base[2] == 1) {
        					base[2]--;
        					score++;
        				}
        				// 1루에 있었다면
        				if(base[1] == 1) {
        					base[1]--;
        					base[3]++;
        				}
        				// 2루 채우기
        				base[2]++;
        			}
        			
        			// 3루타
        			else if(player[n][order[i]] == 3) {
        				// 3루에 있었다면
        				if(base[3] == 1) {
        					base[3]--;
        					score++;
        				}
        				// 2루에 있었다면
        				if(base[2] == 1) {
        					base[2]--;
        					score++;
        				}
        				// 1루에 있었다면
        				if(base[1] == 1) {
        					base[1]--;
        					score++;
        				}
        				// 3루 채우기
        				base[3]++;
        			}
        			
        			//홈런
        			else {
        				// 3루에 있었다면
        				if(base[3] == 1) {
        					base[3]--;
        					score++;
        				}
        				// 2루에 있었다면
        				if(base[2] == 1) {
        					base[2]--;
        					score++;
        				}
        				// 1루에 있었다면
        				if(base[1] == 1) {
        					base[1]--;
        					score++;
        				}
        				score++;
        			}
        		}
        		start = 1;
        	}
        }
        if(score > max) max = score;
        score = 0;
    }
}