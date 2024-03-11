import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int N, result;
	static int[][] arr;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static Queue<Integer> queue = new LinkedList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				arr[r][c] = str.charAt(c)-'0';
			}
		}

		BFS();
		System.out.println(result);
		
		int size = pq.size();
		for(int i=0; i<size; i++) {
			System.out.println(pq.poll());
		}
	}
	
	public static void BFS() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int cnt = 0;
				if(arr[r][c] == 1) {
					// 만약 1이면 offer
					queue.offer(r);
					queue.offer(c);
					// 큐가 비어있지 않을 때까지
					while(!queue.isEmpty()) {
						int pr = queue.poll();
						int pc = queue.poll();
						// 방문처리
						arr[pr][pc] = -1;
						// 가구 수 체크
						cnt++;
						
						for(int d=0; d<4; d++) {
							if(pr+dr[d]>=0 && pr+dr[d]<N && pc+dc[d]>=0 && pc+dc[d]<N) {
								if(arr[pr+dr[d]][pc+dc[d]] == 1) {
									// 4방탐색으로 주변에 1이 있으면 
									// 방문처리하고 queue에 offer
									arr[pr+dr[d]][pc+dc[d]] = -1;
									queue.offer(pr+dr[d]);
									queue.offer(pc+dc[d]);
								}
							} 
						}
					}
					// 우선순위큐에 가구수 등록
					pq.offer(cnt);
					// while문을 탈출하고 큐가 empty라면 result++;
					result++;
				}
			}
		}
	}
}
