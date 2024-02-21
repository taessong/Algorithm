import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		for(int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				if(arr[num] == 1) {
					arr[num] = 0;
				} else {
					arr[num] = 1;
				}
				int index = num;
				while(true) {
					index += num;
					if(index > N) {
						break;
					}
					if(arr[index] <= N && arr[index] == 0) {
						arr[index] = 1;
					} else if(arr[index] <= N && arr[index] == 1) {
						arr[index] = 0;
					}
				}
			} else {
				if(arr[num] == 1) {
					arr[num] = 0;
				} else {
					arr[num] = 1;
				}
				int index = 1;
				while(true) {
					if(num+index > N || num-index < 1) {
						break;
					}
					
					if(arr[num-index] == arr[num+index] && arr[num+index] == 1) {
						arr[num-index] = 0;
						arr[num+index] = 0;
						index++;
					} else if(arr[num-index] == arr[num+index] && arr[num+index] == 0) {
						arr[num-index] = 1;
						arr[num+index] = 1;
						index++;
					} else {
						break;
					}
				}
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] + " ");
			cnt++;
			if(cnt == 20) {
				System.out.println();
				cnt = 0;
			}
		}
	}
}
