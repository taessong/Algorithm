import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M,V;
	public static int[][] arr;
	public static int[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visited = new int[N+1];
		
		// 인접행렬에 1을 넣어 연결된 노드의 관계 나타내기(대칭으로)
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		visited[V] = 1;
		DFS(V);
		
		visited = new int[N+1];
		System.out.println();
		BFS();
	}


	public static void DFS(int num) {
		System.out.print(num+" ");
		
		for(int next=1; next<=N; next++) {
			// 방문했거나, 인접한 노드가 없다면 넘어간다(continue)
			if(visited[next] == 1 || arr[num][next] == 0) {
				continue;
			}
			// if문에 걸리지 않으면 방문하지도 않았고, 인접하지도 않았다는 소리
			// 그 노드를 방문처리하고 재귀 호출
			visited[next] = 1;
			DFS(next);
		}
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[V] = 1;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print(num+" ");
			
			for(int next=1; next<=N; next++) {
				if(visited[next] == 1 || arr[num][next] == 0) {
					continue;
				}
				
				visited[next] = 1;
				// for문 안에서 next로 걸리는
				// 즉 인접하고, 방문하지 않은 노드를 모두 queue에 offer
				// 그럼 큐에 무언가가 들어있기에 while문이 계속해서 반복된다!!
				queue.offer(next);
			}
		}
	}
}

