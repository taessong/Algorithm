import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = 1;
        
        // B에서 A로
        while(B != A) {
        	if(B < A) {
        		System.out.println(-1);
        		return;
        	}
        	
        	String tmp = String.valueOf(B);
        	if(B%2 == 0) {
        		B /= 2;
        	}
        	else if(tmp.charAt(tmp.length()-1) == '1') {
        		tmp = tmp.substring(0, tmp.length()-1);
        		B = Integer.parseInt(tmp);
        	}
        	else {
        		System.out.println(-1);
        		return;
        	}
        	result++;
        }
        System.out.println(result);
    } // main
} // class