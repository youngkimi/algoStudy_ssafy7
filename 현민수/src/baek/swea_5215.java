import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,L;
	static int count;
	static int[] choice,temp;
	static int[][] food;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		count=0;
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			temp = new int[n];
			food = new int[n][2];
			ans = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken());
				food[i][1] = Integer.parseInt(st.nextToken());
			}
			subset(0,0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void subset(int cnt,int score,int limit) {
		if(cnt ==n)
		{	
            if(limit<=L)
				ans = Math.max(ans, score);
			return;
		}
		
		subset(cnt+1,score+food[cnt][0], limit+food[cnt][1]);
		subset(cnt+1,score,limit);
	}
}