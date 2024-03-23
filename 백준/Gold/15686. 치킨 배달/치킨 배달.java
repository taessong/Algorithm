import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int now = Integer.parseInt(st.nextToken());
				// 1(집)이면				
				if(now == 1) home.add(new int[] {r, c});
				// 2(치킨집)이면
				else if(now == 2) chicken.add(new int[] {r, c});
			}
		}
		
		// 치킨집 조합 결과 저장할 배열 
		arr = new int[M][2];
		combination(0, 0);
		System.out.println(result);
	}
	
	public static void combination(int count, int start) {
		// 탈출
		if(count == M) {
			int total = 0;
			for(int i=0; i<home.size(); i++) {
				int homeR = home.get(i)[0];
				int homeC = home.get(i)[1];
				
				int dist = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					int chickenR = arr[j][0];
					int chickenC = arr[j][1];
					
					int path = Math.abs(homeR - chickenR) + Math.abs(homeC - chickenC);
					if(path < dist) dist = path;
				}
				total += dist;
			}
			if(total < result) result = total;
			return;
		}
		
		// 재귀
		// for문을 돌면 알아서 조합이 될 수 있게
		for(int i=start; i<chicken.size(); i++) {
			arr[count] = chicken.get(i);
			combination(count+1, i+1);
		}
	}
}

