import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] blindArr, normalArr;
	static int resultBlindness, resultNormal;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 }; // 상 우 하 좌
	static Queue<Integer> queue = new LinkedList<>();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		blindArr = new int[N][N];
		normalArr = new int[N][N];

		for (int r = 0; r < N; r++) {
			String tmp = br.readLine();
			for (int c = 0; c < N; c++) {
				// R : 1, G : 2, B : 3
				// 색약과 정상인 구별
				if (tmp.charAt(c) == 'R') {
					normalArr[r][c] = 1;
					blindArr[r][c] = 1;
				} else if (tmp.charAt(c) == 'G') {
					normalArr[r][c] = 2;
					blindArr[r][c] = 1;
				} else {
					normalArr[r][c] = 3;
					blindArr[r][c] = 2;
				}
			}
		}

		blindness();
		normal();
		
		sb.append(resultNormal + " " + resultBlindness);
		System.out.println(sb);
	}

	public static void blindness() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 우선 방문한 배열인지 확인
				if (blindArr[r][c] != 0) {
					queue.offer(r);
					queue.offer(c);

					while (!queue.isEmpty()) {
						int pr = queue.poll();
						int pc = queue.poll();
						
						for (int i = 0; i < 4; i++) {
							// 범위 내에 있는지
							if (pr + dr[i] >= 0 && pr + dr[i] < N && pc + dc[i] >= 0 && pc + dc[i] < N) {
								// 현재 선택된 값과 다음에 고려할 값이 같고
								// 다음에 고려할 값이 0이 아니라면 큐에 넣는다!
								if (blindArr[pr][pc] == blindArr[pr + dr[i]][pc + dc[i]] && blindArr[pr + dr[i]][pc + dc[i]] != 0) {
									queue.offer(pr + dr[i]);
									queue.offer(pc + dc[i]);
								}
							}
						}
						// 방문처리
						blindArr[pr][pc] = 0;
					}
					resultBlindness += 1;
				}
			}
		}
	}

	public static void normal() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 우선 방문한 배열인지 확인
				if (normalArr[r][c] != 0) {
					queue.offer(r);
					queue.offer(c);

					while (!queue.isEmpty()) {
						int pr = queue.poll();
						int pc = queue.poll();
						
						for (int i = 0; i < 4; i++) {
							// 범위 내에 있는지
							if (pr + dr[i] >= 0 && pr + dr[i] < N && pc + dc[i] >= 0 && pc + dc[i] < N) {
								// 현재 선택된 값과 다음에 고려할 값이 같고
								// 다음에 고려할 값이 0이 아니라면 큐에 넣는다!
								if (normalArr[pr][pc] == normalArr[pr + dr[i]][pc + dc[i]] && normalArr[pr + dr[i]][pc + dc[i]] != 0) {
									queue.offer(pr + dr[i]);
									queue.offer(pc + dc[i]);
								}
							}
						}
						// 방문처리
						normalArr[pr][pc] = 0;
					}
					resultNormal += 1;
				}
			}
		}
	}
}
