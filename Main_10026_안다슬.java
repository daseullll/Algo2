import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_안다슬 {
	static char[][] arr;
	static int N, cnt, cnt2;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	
	static class Node{ //위치 저장
		int r,c;
		char al;

	public Node(int r, int c, char al) {
		super();
		this.r = r;
		this.c = c;
		this.al = al;
	}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			arr[i]=line.toCharArray();
		}
		
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) bfs(arr,i,j);
			}
		}
		
		sb.append(cnt+" ");
		
		//적록색약
		visited = new boolean[N][N];
		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]=='G') arr[i][j]='R';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) bfs(arr,i,j);
			}
		}
		
		sb.append(cnt);
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(char[][] arr, int r, int c) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(r,c,arr[r][c]));
		
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			Node alpa = queue.poll();
			r = alpa.r;
			c = alpa.c;
			for(int dir=0; dir<4; dir++) {
				int nr = r+delta[dir][0];
				int nc = c+delta[dir][1];
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || arr[nr][nc]!=alpa.al) {
					continue;
				}
				queue.offer(new Node(nr,nc,arr[nr][nc]));
				visited[nr][nc] = true;
			}
		}
		cnt++;
		
	}
	
	

}
