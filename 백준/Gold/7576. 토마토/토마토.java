import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int M, N;
	public static int[][] arr;
	public static Queue<Integer> q = new LinkedList<>();
	public static int[] dr = { 0, -1, 0, 1 }, dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if (arr[r][c] == 1) {
					// 값이 1인 좌표 queue에 저장
					q.offer(r);
					q.offer(c);
				}
			}
		}
		System.out.println(BFS());
	}

	public static int BFS() {
		// queue가 비어있지 않은 동안
		while (!q.isEmpty()) {
			// 나오는 순서대로 r과 c값
			int pr = q.poll();
			int pc = q.poll();

			// 좌,상,우,하 델타배열 순회
			for (int d = 0; d < 4; d++) {
				// 범위 내에 있고
				if (pr + dr[d] >= 0 && pr + dr[d] < N && pc + dc[d] >= 0 && pc + dc[d] < M) {
					// 값이 0이라면
					if (arr[pr + dr[d]][pc + dc[d]] == 0) {
						// 현재 나의 값 + 1
						// 그러면 토마토가 익은 날짜+1이 입력되게 된다!!
						arr[pr + dr[d]][pc + dc[d]] = arr[pr][pc] + 1;
						// BFS를 위해 큐에 값 추가
						q.offer(pr + dr[d]);
						q.offer(pc + dc[d]);
					}
				}
			}
		}

		int max = -1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 안 익은 토마토가 있으면 -1
				if (arr[r][c] == 0) {
					return -1;
				} else if (arr[r][c] > max) {
					// 토마토가 다 익기 위한 날짜를 구하기 위해 max값 업데이트
					max = arr[r][c];
				}
			}
		}

		// max가 1이라는 것은 처음부터 토마토가 다 익어 있다는 것
		if (max == 1) {
			return 0;
		} else { // 그렇지 않다면 max-1이 토마토가 다 익는 데 걸리는 날짜
			return max - 1;
		}
	}
}
