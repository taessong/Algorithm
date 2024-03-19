import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] ground;
	static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Integer> queue = new LinkedList<>();
	static int result = 0, d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ground = new int[N][M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				ground[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		cleaner();
		System.out.println(result);
	}

	public static void cleaner() {
		int pr, pc;
		while (!queue.isEmpty()) {
			pr = queue.poll();
			pc = queue.poll();
			d = queue.poll();

			// 현재 로봇청소기가 위치한 장소가 더럽다면 일단 청소
			if (ground[pr][pc] == 0) {
				ground[pr][pc] = 2;
				result++;
			}

			// 주변에 청소되지 않은 칸이 있는지 탐색
			int tmp = 0;
			for (int i = 0; i < 4; i++) {
				if (ground[pr + dr[i]][pc + dc[i]] != 0) {
					tmp++;
				}
			}

			// 주변이 다 청소되었고, 뒷칸이 벽이 아니라면
			// 방향 유지한채로 후진
			if (tmp == 4) {
				if (ground[pr + dr[(d + 2) % 4]][pc + dc[(d + 2) % 4]] != 1) {
					queue.offer(pr + dr[(d + 2) % 4]);
					queue.offer(pc + dc[(d + 2) % 4]);
					queue.offer(d);
				}
				
				// 주변이 다 청소되었고, 뒷칸이 벽이라면
				// 작동 종료
				else {
					return;
				}
			}

			// 주변이 다 청소되지 않았다면
			else {
				while (true) {
					// 반시계로 90도 회전
					d = (d + 3) % 4;
					// 바라보는 방향의 앞쪽이 청소되지 않았다면 전진
					if (ground[pr + dr[d]][pc + dc[d]] == 0) {
						queue.offer(pr + dr[d]);
						queue.offer(pc + dc[d]);
						queue.offer(d);
						break;
					}
				}
			}
		}
	}
}
