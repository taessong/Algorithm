import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h, pr, pc;
	static int[] person;
	static char[][] building;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static Queue<int[]> queue;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			building = new char[h][w];
			visited = new boolean[h][w];
			queue = new LinkedList<>();
			q = new LinkedList<>();
//			System.out.println("w "+w);

			for (int r = 0; r < h; r++) {
				String str = br.readLine();
				for (int c = 0; c < w; c++) {
					building[r][c] = str.charAt(c);
					if (building[r][c] == '*') {
						queue.offer(new int[] { r, c });
						visited[r][c] = true;
					} else if (building[r][c] == '@')
						q.offer(new int[] { r, c });
				}
			}

			int result = 0;
			result = fire();
			if (result == 0)
				sb.append("IMPOSSIBLE" + "\n");
			else
				sb.append(result + "\n");
			
//			for(int r=0; r<h; r++) {
//				for(int c=0; c<w; c++) {
//					System.out.print(building[r][c]);
//				}
//				System.out.println();
//			}
			
		} // for testcase
		System.out.println(sb);
	} // main

	public static int fire() {
		int time = 1;
		while (!queue.isEmpty() || !q.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] arr = queue.poll();

				// 불이 먼저 이동
				for (int d = 0; d < 4; d++) {
					int nr = arr[0] + dr[d];
					int nc = arr[1] + dc[d];
					if (nr >= 0 && nr < h && nc >= 0 && nc < w && building[nr][nc] != '#' && !visited[nr][nc]) {
						building[nr][nc] = '*';
						queue.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
//						System.out.println("fire " + nr + " " + nc);
					}
				} // for dir
			} // for queue.size

			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] p = q.poll();
//				System.out.println("p0 "+p[0]);
				if(p[0] == 0 || p[1] == 0 || p[0] == h-1 || p[1] == w-1) return time;
				
				for (int d = 0; d < 4; d++) {
					int nr = p[0] + dr[d];
					int nc = p[1] + dc[d];
					if (nr >= 0 && nr < h && nc >= 0 && nc < w && building[nr][nc] == '.') {
//						System.out.println("person " + nr + " " + nc);
						building[nr][nc] = '@';
						q.offer(new int[] { nr, nc });
					}
				}
			} // qsize
			time++;
//			System.out.println(time);
		} // while
		return 0;
	} // fire()
} // class