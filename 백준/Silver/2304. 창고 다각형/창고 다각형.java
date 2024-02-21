import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[1001];
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int maxIndex = 0;
		int last = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;

			if(max < H) {
				max = H;
				maxIndex = L;
			}
			if(last < L) {
				last = L;
			}
		}
		
		int sum = 0;
		int height = 0;
		for(int i=0; i<maxIndex; i++) {
			if(arr[i] != 0 && arr[i] > height) {
				height = arr[i];
			}
			sum += height;
		}
		
		int height2 = 0;
		for(int i=last; i>maxIndex; i--) {
			if(arr[i] != 0 && arr[i] > height2) {
				height2 = arr[i];
			}
			sum += height2;
		}
		System.out.println(sum + max);
    }
}