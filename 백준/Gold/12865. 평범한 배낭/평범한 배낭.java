import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int W = sc.nextInt();
    	int[] weight = new int[N+1];
    	int[] cost = new int[N+1];
    	int[][] dp = new int[N+1][W+1];
    	
    	for(int n=1; n<=N; n++) {
    		weight[n] = sc.nextInt();
    		cost[n] = sc.nextInt();
    	}
    	
    	for(int n=1; n<=N; n++) {
    		for(int w=1; w<=W; w++) {
    			if(w >= weight[n]) dp[n][w] = Math.max(dp[n-1][w], dp[n-1][w-weight[n]]+cost[n]);
    			else dp[n][w] = dp[n-1][w];
    		}
    	}
    	System.out.println(dp[N][W]);
    } // main
} // class