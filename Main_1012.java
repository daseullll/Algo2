import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
	static int delta[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int M, N, map[][], cnt, K;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb  = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			cnt = 0;
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
				
			}
			// ----input end----
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && visited[i][j]==false) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
		
	}

	public static void find(int r, int c) {

		for (int dir = 0; dir < 4; dir++) {
			visited[r][c] = true;
			int rn = r + delta[dir][0];
			int cn = c + delta[dir][1];
			if(rn<0 || rn>=N || cn<0 || cn>=M || visited[rn][cn]==true || map[rn][cn]==0) { //가지 않을 조건
				continue;
			}
			r = rn;
			c = cn;
			dir=-1;
		}
		cnt++;

	}
	
	public static void dfs(int r, int c) {
		for (int dir = 0; dir < 4; dir++) {
			visited[r][c] = true;
			int rn = r + delta[dir][0];
			int cn = c + delta[dir][1];
			if(rn<0 || rn>=N || cn<0 || cn>=M || visited[rn][cn]==true || map[rn][cn]==0) { //가지 않을 조건
				continue;
			}else {
				dfs(rn,cn);
			}
			
		}
		
	}

}
